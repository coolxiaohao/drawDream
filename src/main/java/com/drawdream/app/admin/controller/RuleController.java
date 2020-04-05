package com.drawdream.app.admin.controller;

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

    @RequestMapping("/createRule")
    public JsonResult createRuleController(){
        return ruleService.createRule();
    }
}
