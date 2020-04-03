package com.drawdream.app.admin.controller;

import cn.hutool.db.nosql.redis.RedisDS;
import cn.hutool.json.JSONObject;
import com.drawdream.app.admin.pojo.Admin;
import com.drawdream.app.admin.service.AdminService;
import com.drawdream.app.base.pojo.JsonResult;
import com.drawdream.app.base.service.BaseLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private static  Jedis jedis = RedisDS.create().getJedis();
    /**
     * @desc: 构造方法注入bean 的优点
     * 依赖不可变 components as immutable objects ，即注入对象为final
     * 依赖不可为空required dependencies are not null，省去对注入参数的检查。当要实例化FooController的时候，由于只有带参数的构造函数，spring注入时需要传入所需的参数，所以有两种情况：1) 有该类型的参数传入 => ok; 2) 无该类型参数传入，报错
     * 提升了代码的可复用性：非IOC容器环境可使用new实例化该类的对象。
     * 避免循环依赖：如果使用构造器注入，在spring项目启动的时候，就会抛出：BeanCurrentlyInCreationException：Requested bean is currently in creation: Is there an unresolvable circular reference？从而提醒你避免循环依赖，如果是field注入的话，启动的时候不会报错，在使用那个bean的时候才会报错。
     *
     * */
    private final AdminService adminService;
    private final BaseLoginService loginService;
    /**
     * @param adminService 管理员service
     * @param loginService 登录service
     * @desc: 构造方法初始化注入
     * @author: tanhao
     * @date: 2020-04-03 09:18
     */
    @Autowired
    public AdminController(AdminService adminService, BaseLoginService loginService) {
        this.adminService = adminService;
        this.loginService = loginService;
    }

    @RequestMapping("/getAdmin")
    public Admin getAdmin(int id){
        Admin admin = new Admin();
        if (id > 0){
            admin= adminService.findAdminById(id);
//            jedis.set("admin", );
        }else {
            admin = null;
        }
       return admin;
    }

    @RequestMapping("getRedisName")
    public String getAdminName(){
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
    }
}
