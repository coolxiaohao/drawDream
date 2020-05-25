package com.drawdream.app.admin.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import cn.hutool.setting.Setting;
import com.drawdream.app.admin.dao.RuleDao;
import com.drawdream.app.admin.pojo.Admin;
import com.drawdream.app.admin.pojo.Rule;
import com.drawdream.app.admin.service.AdminService;
import com.drawdream.app.admin.service.RuleService;
import com.drawdream.app.base.pojo.JsonResult;
import com.drawdream.app.base.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc: 权限生成类
 * @package: com.drawdream.app.admin.service.impl
 * @fileName: RuleServiceImpl
 * @author: tanhao
 * @date: 2020-04-03 14:30
 */
@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    private RuleDao ruleDao;
    @Autowired
    private AdminService adminService;

    @Override
    public int addRule(Rule rule) {
        return ruleDao.addRule(rule);
    }

    @Override
    public Rule getRule(String accessPath) {
        return ruleDao.getRule(accessPath);
    }

    @Override
    public JsonResult createRule() {
        /*获取登录信息进行认证*/
        if (!StrUtil.hasEmpty(TokenUtil.getTokenAdminId())){
            int adminId=Integer.parseInt(TokenUtil.getTokenAdminId());
            Admin admin = adminService.findAdminById(adminId);
            if (!admin.getAdminName().equals("admin")){
                return JsonResult.errorMsg(500,"请登录最高权限账号！");
            }
        }else {
            return JsonResult.errorMsg(500,"请先登录！");
        }
        /*扫描新添加权限*/
        String[] ports = {"admin","home","api"};
        Setting  setting = new Setting("rules/application-rules.setting");
        Setting  rules = new Setting("rules/rules.setting");
        Rule rule = new Rule();
        int count = 0;
        for (String port: ports) {
            JSONArray array= JSONUtil.parseArray(setting.getStr(port));
            for ( Object i: array) {
                String key = i.toString()+".";
                String ruleName = rules.getStr(key+"ruleName");
                String accessPath = rules.getStr(key+"accessPath");
                String type= rules.getStr(key+"type");
                String needRule= rules.getStr(key+"needRule");
                assert rule != null;
                /*查询当前权限在表中是否已存在*/
                Rule access= getRule(accessPath);
                if (!ObjectUtil.hasEmpty(access)){
                    continue;
                }
                if (!StrUtil.hasEmpty(ruleName)){
                    rule.setAdminRuleName(ruleName);
                }
                if (NumberUtil.isNumber(type)){
                    rule.setType(Integer.parseInt(type));
                }
                if (NumberUtil.isNumber(needRule)){
                    rule.setNeedRule(Integer.parseInt(needRule));
                }
                if (!StrUtil.hasEmpty(accessPath)){
                    rule.setAccessPath(accessPath);
                    rule.setPort(port);
                    rule.setAddTime(new DateTime());
                    addRule(rule);
                    count++;
                }
            }
        }
        if (count > 0){
            return JsonResult.success(200,"生成权限成功");
        }else {
            return JsonResult.errorMsg(500,"当前没有权限需要生成，请检查配置文件");
        }

    }

    @Override
    public String getAccessPath(int id) {
        return ruleDao.getAccessPath(id);
    }

    @Override
    public JsonResult getLoginRules(String path) {
        return JsonResult.success(200,ruleDao.getRule(path));
    }
}
