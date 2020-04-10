package com.drawdream.app.base.service;

import com.drawdream.app.admin.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface BaseUserService {
    int updUser(@Param("User") User user);
}
