package com.drawdream.app.admin.service;

import com.drawdream.app.admin.pojo.RuleGroup;
import org.apache.ibatis.annotations.Param;

/**
 * @desc: 权限组业务实现层
 * @package: com.drawdream.app.admin.service
 * @fileName: RuleGroupService
 * @author: tanhao
 * @date: 2020-04-06 14:54
 */
public interface RuleGroupService {
    int addRuleGroup(@Param("ruleGroup") RuleGroup ruleGroup);
}
 