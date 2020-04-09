package com.drawdream.app.admin.service;

import com.drawdream.app.admin.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface AdminUserService {
    int addAdminUser(@Param("User") User user);
}
