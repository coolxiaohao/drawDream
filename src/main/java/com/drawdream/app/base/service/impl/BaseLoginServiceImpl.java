package com.drawdream.app.base.service.impl;

import cn.hutool.core.io.watch.WatchException;
import cn.hutool.db.nosql.redis.RedisDS;
import com.drawdream.app.admin.pojo.Admin;
import com.drawdream.app.admin.service.AdminService;
import com.drawdream.app.base.pojo.JsonResult;
import com.drawdream.app.base.service.BaseLoginService;
import com.drawdream.app.base.service.ToKenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @desc: 公用登录业务实现层
 * @package: com.drawdream.app.base.service.impl
 * @fileName: BaseLoginServiceImpl
 * @author: tanhao
 * @date: 2020-04-02 16:57
 */
@Service
public class BaseLoginServiceImpl implements BaseLoginService {

//    private Jedis jedis = RedisDS.create().getJedis();
    @Autowired
    private AdminService adminService;
    @Autowired
    private ToKenService toKenService;

    @Override
    public JsonResult logins(String username, String password, String type) {
        String admin = "admin";
        String home = "home";
        if (admin.equals(type)) {
            return AdminLogin(username, password);
        } else if (home.equals(type)) {
            return HomeLogin(username, password);
        } else {
            return ApiLogin(username, password);
        }
    }

    /**
     * @desc: 后台登录实现
     * @author: tanhao
     * @date: 2020-04-02 17:06
     */
    public JsonResult AdminLogin(String username, String password) {
        if (username == null || username.equals("")){
            return JsonResult.errorMsg(500, "用户名不能为空");
        }
        Admin admin = adminService.findByAdminName(username);
        if (admin == null){
            return JsonResult.errorMsg(500, "登录失败,用户不存在");
        }else {
            //后期密码需要进行加密
            if (!admin.getAdminPwd().equals(password)){
                return JsonResult.errorMsg(500, "密码错误");
            }else {
                admin.setAdminToken(toKenService.getToken(admin.getId(),admin.getAdminPwd()));
                return JsonResult.success(admin);
            }
        }
    }

    public JsonResult HomeLogin(String username, String password) {
        return null;
    }

    public JsonResult ApiLogin(String username, String password) {
        return null;
    }
}
