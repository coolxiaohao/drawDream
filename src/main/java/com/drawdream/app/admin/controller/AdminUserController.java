package com.drawdream.app.admin.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.drawdream.app.admin.pojo.User;
import com.drawdream.app.admin.service.AdminUserService;
import com.drawdream.app.base.pojo.JsonResult;
import com.drawdream.app.base.service.BaseUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/adminUser")
public class AdminUserController {

    private final AdminUserService adminUserService;
    private final BaseUserService baseUserService;

    public AdminUserController(AdminUserService adminUserService, BaseUserService baseUserService) {
        this.adminUserService = adminUserService;
        this.baseUserService = baseUserService;
    }

    /**
     * @return :JsonResult
     * @desc ：管理员新增User用户
     * @Author : huangxinxin
     * @date : 2020/4/8
     */
    @RequestMapping("/addAdminUser")
    private JsonResult addAdminUser(String userName, String userPwd,  String userDealPwd, Integer status, String userPhone){
        User user=new User();
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
            return JsonResult.errorMsg(400,"添加失败！");
        }
    }

    /**
     * @return :JsonResult
     * @desc ：管理员修改User用户信息
     * @Author : huangxinxin
     * @date : 2020/4/10
     */
    @RequestMapping("/updUser")
    private JsonResult updUser(Integer id,String userName,String userPwd,String repeatPwd,String userDealPwd,Integer status,String userPhone) {
        User user = new User();
        user.setId(id);
        if (StrUtil.hasEmpty(userName)) {
            return JsonResult.errorMsg(400, "用户名为空！");
        }
        user.setUserName(userName);
        if (StrUtil.hasEmpty(SecureUtil.md5(userPwd))) {
            return JsonResult.errorMsg(400, "用户密码为空！");
        }
        if (!userPwd.equals(repeatPwd)) {
            return JsonResult.errorMsg(400, "两次输入密码错误！");
        }
        user.setUserPwd(SecureUtil.md5(userPwd));
        user.setUserDealPwd(SecureUtil.md5(userDealPwd));
        if (status == null) {
            return JsonResult.errorMsg(400, "状态码为空！");
        }
        user.setStatus(status);
        user.setUserPhone(userPhone);
        user.setEditTime(new DateTime());
//        DateTime dateTime = new DateTime(); //你这不是废话 肯定是这个问题啦
//        System.out.println(new DateTime().toString());//??不可以输出到控制台的咩 热部署好像有问题 到时候看看
        int count = baseUserService.updUser(user);
        if (count>0) {
            return JsonResult.success(200,"修改成功！");
        } else {
            return JsonResult.errorMsg(500,"修改失败！");

        }
    }
}
