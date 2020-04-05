package com.drawdream.app.admin.dao;

import com.drawdream.app.admin.pojo.Rule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @desc: todo
 * @package: com.drawdream.app.admin.dao
 * @fileName: RuleDao
 * @author: tanhao
 * @date: 2020-04-03 14:30
 */
@Repository
public interface RuleDao {
    int addRule(@Param("rule") Rule rule);
    Rule getRule(@Param("accessPath")  String accessPath);
    String getAccessPath(@Param("id")  int id);
}
