package com.drawdream.app.admin.service;

import com.drawdream.app.admin.pojo.Rule;
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

}
