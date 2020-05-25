package com.drawdream.app.admin.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import com.drawdream.app.admin.pojo.RuleGroup;
import com.drawdream.app.admin.service.RuleGroupService;
import com.drawdream.app.base.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 权限组操作
 * @package: com.drawdream.app.admin.controller
 * @fileName: RuleGroupController
 * @author: tanhao
 * @date: 2020-04-06 14:47
 */
@RestController
@RequestMapping("/ruleGroup")
public class RuleGroupController {
    @Autowired
    private RuleGroupService ruleGroupService;

    @RequestMapping("/addRuleGroup")
    public JsonResult addRuleGroup(String group,String groupName,int type,int isDefault){
        RuleGroup ruleGroup = new RuleGroup();
        if (!StrUtil.hasEmpty(groupName)){
            ruleGroup.setGroupName(groupName);
        }
        if (!StrUtil.hasEmpty(group)){
            ruleGroup.setRuleGroup(group);
        }
        ruleGroup.setIsDefault(isDefault);
        ruleGroup.setType(type);
        ruleGroup.setAddTime(new DateTime());
        int count = ruleGroupService.addRuleGroup(ruleGroup);
        if (count > 0){
            return JsonResult.success(200,"添加成功!");
        }else {
            return JsonResult.errorMsg(400,"添加权限组失败！");
        }
    }
}
