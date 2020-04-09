package com.drawdream.app.admin.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.drawdream.app.admin.pojo.User;
import com.drawdream.app.admin.service.AdminUserService;
import com.drawdream.app.base.pojo.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/adminUser")
public class AdminUserController {

    private final AdminUserService adminUserService;

    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    /**
     * @return :JsonResult
     * @desc ：管理员新增User用户
     * @Author : huangxinxin
     * @date : 2020/4/8
     */
    @RequestMapping("/addAdminUser")
    private JsonResult addAdminUser(String userName, String userPwd, String userKey, String userDealPwd, String userDealKey, Integer status, String userPhone){
        User user=new User();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        if(!StrUtil.hasEmpty(userName)){
            user.setUserName(userName);
        }
        if (!StrUtil.hasEmpty(userPwd)){
            user.setUserPwd(SecureUtil.md5(userPwd));
        }
        if (!StrUtil.hasEmpty(userDealPwd)){
            user.setUserDealPwd(SecureUtil.md5(userDealPwd));
        }
        if (status!=null){
            user.setStatus(status);
        }
        if (!StrUtil.hasEmpty(userPhone)){
            user.setUserPhone(userPhone);
        }
        user.setAddTime(new DateTime());
        System.out.println(user.toString());
        int count=adminUserService.addAdminUser(user);
        if (count > 0){
            return JsonResult.success(200,"添加成功！");
        }else {
            return JsonResult.errorMsg(400,"添加失败");
        }
    }
}
