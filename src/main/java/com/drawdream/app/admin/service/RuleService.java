package com.drawdream.app.admin.service;

import cn.hutool.setting.Setting;
import com.drawdream.app.admin.pojo.Rule;
import com.drawdream.app.base.pojo.JsonResult;
import org.apache.ibatis.annotations.Param;

/**
 * @desc: 权限处理
 * @package: com.drawdream.app.admin.service
 * @fileName: RuleService
 * @author: tanhao
 * @date: 2020-04-03 14:28
 */
public interface RuleService {
    int addRule(@Param("rule")  Rule rule);
    Rule getRule(@Param("accessPath")  String accessPath);
    JsonResult createRule();
    String getAccessPath(@Param("id")  int id);
    JsonResult getLoginRules(String path);
}
