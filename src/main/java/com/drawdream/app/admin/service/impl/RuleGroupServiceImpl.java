package com.drawdream.app.admin.service.impl;

import com.drawdream.app.admin.dao.RuleGroupDao;
import com.drawdream.app.admin.pojo.RuleGroup;
import com.drawdream.app.admin.service.RuleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc: todo
 * @package: com.drawdream.app.admin.service.impl
 * @fileName: RuleGroupServiceImpl
 * @author: tanhao
 * @date: 2020-04-06 14:54
 */
@Service
public class RuleGroupServiceImpl implements RuleGroupService {
    private final RuleGroupDao ruleGroupDao;
    @Autowired
    public RuleGroupServiceImpl(RuleGroupDao ruleGroupDao) {
        this.ruleGroupDao = ruleGroupDao;
    }

    @Override
    public int addRuleGroup(RuleGroup ruleGroup) {
        return ruleGroupDao.addRuleGroup(ruleGroup);
    }
}
