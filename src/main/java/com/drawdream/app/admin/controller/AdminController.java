package com.drawdream.app.admin.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.db.nosql.redis.RedisDS;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.drawdream.app.admin.pojo.Admin;
import com.drawdream.app.admin.service.AdminService;
import com.drawdream.app.base.pojo.JsonResult;
import com.drawdream.app.base.service.BaseLoginService;
import com.drawdream.app.base.utils.RedisUtil;
import com.drawdream.app.base.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: admin
 * @package: com.drawdream.app.admin.controller
 * @fileName: AdminContorller.java
 * @author: tanhao
 * @date: 2020-03-31 13:31
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
//    private static Jedis jedis = RedisDS.create().getJedis();
    private static RedisUtil redisUtil = new RedisUtil();
    /**
     * @desc: 构造方法注入bean 的优点
     * 依赖不可变 components as immutable objects ，即注入对象为final
     * 依赖不可为空required dependencies are not null，省去对注入参数的检查。当要实例化FooController的时候，由于只有带参数的构造函数，spring注入时需要传入所需的参数，所以有两种情况：1) 有该类型的参数传入 => ok; 2) 无该类型参数传入，报错
     * 提升了代码的可复用性：非IOC容器环境可使用new实例化该类的对象。
     * 避免循环依赖：如果使用构造器注入，在spring项目启动的时候，就会抛出：BeanCurrentlyInCreationException：Requested bean is currently in creation: Is there an unresolvable circular reference？从而提醒你避免循环依赖，如果是field注入的话，启动的时候不会报错，在使用那个bean的时候才会报错。
     */
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
    public Admin getAdmin(int id) {
        Admin admin = new Admin();
        if (id > 0) {
            admin = adminService.findAdminById(id);
        } else {
            admin = null;
        }
        return admin;
    }


    @RequestMapping("getRedisName")
    public String getAdminName() {
        return redisUtil.get("login_admin");
    }

    /**
     * @return JsonResult
     * @desc: 后台登录
     * @author: tanhao
     * @date: 2020-04-02 16:48
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult Login(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println(request.getParameter("username"));
        return loginService.logins(request.getParameter("username"), request.getParameter("password"), "admin",request.getParameter("varify"),request.getParameter("varifyCode"));
    }

    /**
     * @return :JsonResult
     * @desc ：添加管理员
     * @Author : huangxinxin
     * @date : 2020/4/8
     */
    @RequestMapping("/addAdmin")
    public JsonResult AddAdmin(String adminName, String pwd, String actionPwd, String Phone, int ruleId, String headPortrait) {
        Admin admin = new Admin();
        if (!StrUtil.hasEmpty(adminName)) {
            admin.setAdminName(adminName);
        }
        if (!StrUtil.hasEmpty(pwd)) {
            admin.setAdminPwd(SecureUtil.md5(pwd));
        }
        if (!StrUtil.hasEmpty(actionPwd)) {
            admin.setAdminActionPwd(SecureUtil.md5(actionPwd));
        }
        if (!StrUtil.hasEmpty(Phone)) {
            admin.setAdminPhone(Phone);
        }
        if (!StrUtil.hasEmpty(headPortrait)) {
            admin.setHeadPortrait(headPortrait);
        }
        if (ruleId > 0) {
            admin.setAdminRuleId(ruleId);
        } else {
            admin.setAdminRuleId(0);
        }
        admin.setAddTime(new DateTime());
        int count = adminService.addAdminInfo(admin);
        if (count > 0) {
            return JsonResult.success(200, "添加成功！");
        } else {
            return JsonResult.errorMsg(400, "添加失败");
        }
    }

    /**
     * @return :JsonResult
     * @desc ：根据密码修改管理员的登录密码，操作密码
     * @Author : huangxinxin
     * @date : 2020/4/8
     */
    @RequestMapping("/updPwdAdmin")
    public JsonResult updPwdAdmin(String type, String oldPwd, String newPwd, String repeatPwd, String actionPwd) {
        Admin admin = null;
        if (!StrUtil.hasEmpty(TokenUtil.getTokenAdminId())) {
            int adminId = Integer.parseInt(TokenUtil.getTokenAdminId());
            admin = adminService.findAdminById(adminId);
        } else {
            return JsonResult.errorMsg(400, "请先登录！");
        }
        if (!newPwd.equals(repeatPwd) || newPwd.isEmpty()) {
            return JsonResult.errorMsg(400, "两次密码不一致或为空，请重新输入！");
        }
        if (type.equals("actionPwd")) {
            if (!admin.getAdminActionPwd().equals(SecureUtil.md5(oldPwd))) {
                return JsonResult.errorMsg(400, "旧密码错误，请重新输入！");
            }
            admin.setAdminActionPwd(newPwd);
        } else {
            if (!admin.getAdminActionPwd().equals(SecureUtil.md5(actionPwd))) {
                return JsonResult.errorMsg(400, "操作密码错误，请重新输入！");
            }
            if (!admin.getAdminPwd().equals(SecureUtil.md5(oldPwd))) {
                return JsonResult.errorMsg(400, "旧密码错误，请重新输入！");
            }
            admin.setAdminPwd(newPwd);
        }
        redisUtil.set(admin.getAdminName(), admin);
        adminService.updPwdAdmin(SecureUtil.md5(newPwd), admin.getId(), type);
        return JsonResult.success();
    }

    /**
     * @desc: 获取图形验证码
     * @author: tanhao
     * @date: 2020-04-18 13:58
     */
    @RequestMapping(value = "/generateValidateCode", method = RequestMethod.GET)
    public JsonResult getValidateCode() {
        /*生成图形验证码*/
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(200, 100, 4, 4);
        String img = captcha.getImageBase64();
        String code = captcha.getCode();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("captchaImg","data:image/png;base64," + img);
        String key = IdUtil.randomUUID();
        jsonObject.put("varify",key);
        //生存120秒 也就是两分钟
        redisUtil.set(key,code,120);
        return JsonResult.success(200,jsonObject);
    }

}
