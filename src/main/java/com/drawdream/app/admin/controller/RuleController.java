package com.drawdream.app.admin.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import cn.hutool.setting.Setting;
import com.drawdream.app.admin.pojo.Rule;
import com.drawdream.app.admin.service.RuleService;
import com.drawdream.app.base.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 权限控制层
 * @package: com.drawdream.app.admin.controller
 * @fileName: RuleController
 * @author: tanhao
 * @date: 2020-04-03 10:10
 */
@RestController
@RequestMapping("/rules")
public class RuleController {

    private final RuleService ruleService;
    @Autowired
    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @RequestMapping("/getAdminRule")
    public JsonResult getAdminRules(){
        String[] ports = {"admin","home","api"};
        Rule rule = new Rule();
        Setting  setting = new Setting("rules/application-rules.setting");
        Setting  rules = new Setting("rules/rules.setting");

        for (String port: ports) {
            JSONArray array= JSONUtil.parseArray(setting.getStr(port));
            for ( Object i: array) {
                //获取权限组进行新增
                String key = i.toString()+".";
                String ruleName = rules.getStr(key+"ruleName");
                String accessPath = rules.getStr(key+"accessPath");
                String type= rules.getStr(key+"type");
                String needRule= rules.getStr(key+"needRule");
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
                    System.out.println(rule.toString());
                    ruleService.addRule(rule);
                    System.out.println(rule.toString());
                }
                rule = null;
            }
        }

        return JsonResult.success(200,rule);
    }
}
