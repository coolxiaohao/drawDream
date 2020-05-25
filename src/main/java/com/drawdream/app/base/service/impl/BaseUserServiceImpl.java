package com.drawdream.app.base.service.impl;

import com.drawdream.app.admin.dao.AdminUserDao;
import com.drawdream.app.admin.pojo.User;
import com.drawdream.app.base.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseUserServiceImpl implements BaseUserService {
    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public int updUser(User user) {
        return adminUserDao.updUser(user);
    }
}
