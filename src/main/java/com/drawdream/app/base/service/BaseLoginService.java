package com.drawdream.app.base.service;

import com.drawdream.app.base.pojo.JsonResult;
import org.apache.ibatis.annotations.Param;

/**
 * @desc: 登录业务层
 * @package: com.drawdream.app.base.service
 * @fileName: BaseLoginService
 * @author: tanhao
 * @date: 2020-04-02 16:51
 */
public interface BaseLoginService {
    /**
     * @desc: 登录
     * @author: tanhao
     * @date: 2020-04-02 16:56
     */
    public JsonResult logins(@Param("username") String username, @Param("password") String password, @Param("type") String type,@Param("varify") String varify,@Param("varifyCode") String varifyCode);
}
