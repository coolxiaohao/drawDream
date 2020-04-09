package com.drawdream.app.admin.service.impl;


import com.drawdream.app.admin.dao.AdminUserDao;
import com.drawdream.app.admin.pojo.User;
import com.drawdream.app.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserDao adminUserDao;

    @Autowired
    public AdminUserServiceImpl(AdminUserDao adminUserDao) {
        this.adminUserDao = adminUserDao;
    }

    @Override
    public int addAdminUser(User user) {
        return adminUserDao.addAdminUser(user);
    }
}
