package com.drawdream.app.admin.contorller;

import cn.hutool.db.nosql.redis.RedisDS;
import com.drawdream.app.admin.pojo.Admin;
import com.drawdream.app.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/admin")
public class AdminContorller {

//    private static Jedis jedis= RedisDS.create().getJedis();

    @Autowired
    private AdminService adminService;

    @RequestMapping("/getAdmin")
    public Admin getAdmin(int id){
//        Jedis jedis = RedisDS.create().getJedis();
        Admin admin = new Admin();
        System.out.println(id);
        if (id > 0){
            admin= adminService.getAdmin(id);
        }else {
            admin = null;
        }
//        jedis
//        jedis.set("admin",admin.toString());
       return admin;
    }

    @RequestMapping("getRedisName")
    public String getAdminName(){
        Jedis jedis = RedisDS.create().getJedis();
        return  jedis.get("admin");
    }
}
