package com.drawdream.app.admin.service.impl;

import com.drawdream.app.admin.dao.AdminDao;
import com.drawdream.app.admin.pojo.Admin;
import com.drawdream.app.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

/**
 * @desc: AdminService 实现
 * @package: com.drawdream.app.admin.service.impl
 * @fileName: AdminServiceImpl.java
 * @author: tanhao
 * @date: 2020-04-03 09:12
 */

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findByAdminName(String adminName) {
        return adminDao.findByAdminName(adminName);
    }

    @Override
    public Admin findAdminById(int id) {
        return adminDao.findAdminById(id);
    }

    @Override
    public int addAdminInfo(Admin admin) {
        return adminDao.addAdminInfo(admin);
    }

    @Override
    public int updPwdAdmin(String password, Integer id,String passwordName) {
        return adminDao.updPwdAdmin(password,id,passwordName);
    }
}
