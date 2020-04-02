package com.drawdream.app.admin.controller;

import cn.hutool.db.nosql.redis.RedisDS;
import com.drawdream.app.admin.pojo.Admin;
import com.drawdream.app.admin.service.AdminService;
import com.drawdream.app.base.pojo.JsonResult;
import com.drawdream.app.base.service.BaseLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@RestController

/**
 * @desc: admin
 * @package: com.drawdream.app.admin.controller
 * @fileName: AdminContorller.java
 * @author: tanhao
 * @date: 2020-03-31 13:31
 */
@RestController
@RequestMapping("/admin")
public class AdminController{
    @Autowired
    private AdminService adminService;

    @Autowired
    private BaseLoginService loginService;

    @RequestMapping("/getAdmin")
    public Admin getAdmin(int id){
        Admin admin = new Admin();
        System.out.println(id);
        if (id > 0){
            admin= adminService.findAdminById(id);
        }else {
            admin = null;
        }
       return admin;
    }

    @RequestMapping("getRedisName")
    public String getAdminName(){
        Jedis jedis = RedisDS.create().getJedis();
        return  jedis.get("admin");
    }

    /**
     * @desc: 后台登录
     * @author: tanhao
     * @date: 2020-04-02 16:48
     * @return JsonResult
     */
    @RequestMapping("/login")
    public JsonResult Login(HttpServletRequest request, HttpServletResponse response) {
       return loginService.logins(request.getParameter("username"),request.getParameter("password"),"admin");
//        return JsonResult.success(200,"123456");
    }
}
