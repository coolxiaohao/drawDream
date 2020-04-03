package com.drawdream.app.admin.service.impl;

import com.drawdream.app.admin.dao.AdminDao;
import com.drawdream.app.admin.pojo.Admin;
import com.drawdream.app.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc: AdminService 实现
 * @package: com.drawdream.app.admin.service.impl
 * @fileName: AdminServiceImpl.java
 * @author: tanhao
 * @date: 2020-04-03 09:12
 */

@Service
public class AdminServiceImpl implements AdminService {
    /**
     * @desc: 构造方法形式的注入
     * @author: tanhao
     * @date: 2020-04-03 09:15
     */
    private final AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin findByAdminName(String adminName) {
        return adminDao.findByAdminName(adminName);
    }

    @Override
    public Admin findAdminById(int id) {
        return adminDao.findAdminById(id);
    }
}
