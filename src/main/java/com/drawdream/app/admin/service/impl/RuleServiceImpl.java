package com.drawdream.app.admin.service.impl;

import com.drawdream.app.admin.dao.RuleDao;
import com.drawdream.app.admin.pojo.Rule;
import com.drawdream.app.admin.service.RuleService;
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
    private final RuleDao ruleDao;

    @Autowired
    public RuleServiceImpl(RuleDao ruleDao) {
        this.ruleDao = ruleDao;
    }

    @Override
    public int addRule(Rule rule) {
        return ruleDao.addRule(rule);
    }
}
