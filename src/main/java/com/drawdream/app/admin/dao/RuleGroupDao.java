package com.drawdream.app.admin.dao;

import com.drawdream.app.admin.pojo.RuleGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @desc: todo
 * @package: com.drawdream.app.admin.dao
 * @fileName: RuleGroupDao
 * @author: tanhao
 * @date: 2020-04-06 14:53
 */
@Repository
public interface RuleGroupDao {
    int addRuleGroup(@Param("ruleGroup") RuleGroup ruleGroup);
}
