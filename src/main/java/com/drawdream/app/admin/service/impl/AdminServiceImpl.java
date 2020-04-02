package com.drawdream.app.admin.service.impl;

import com.drawdream.app.admin.dao.AdminDao;
import com.drawdream.app.admin.pojo.Admin;
import com.drawdream.app.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
