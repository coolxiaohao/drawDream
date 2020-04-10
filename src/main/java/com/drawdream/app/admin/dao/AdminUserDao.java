package com.drawdream.app.admin.dao;


import com.drawdream.app.admin.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserDao {

    int addAdminUser(@Param("User") User user);

    int updUser(@Param("User")User user);
}
