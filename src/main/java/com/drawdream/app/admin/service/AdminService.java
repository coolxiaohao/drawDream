package com.drawdream.app.admin.service;

import com.drawdream.app.admin.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @desc: admin
 * @package: com.drawdream.app.admin.service
 * @fileName: AdminService.java
 * @author: tanhao
 * @date: 2020-04-03 09:04
 */

public interface AdminService {
    /**
     * 根据管理员名称查找对象
     * @param adminName 管理员名称
     * @desc: 根据管理员名称查找对象
     * @author: tanhao
     * @date: 2020-04-03 09:06
     * @return Admin
     */
    Admin findByAdminName(@Param("adminName") String adminName);

    /**
     * 根据管理员id查找对象
     * @param id 管理员id
     * @desc: 根据管理员id查找对象
     * @author: tanhao
     * @date: 2020-04-03 09:07
     * @return Admin
     */
    Admin findAdminById(@Param("id") int id);
    int addAdminInfo(@Param("admin") Admin admin);
}
