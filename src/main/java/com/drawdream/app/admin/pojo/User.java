package com.drawdream.app.admin.pojo;

import cn.hutool.core.date.DateTime;

import java.util.Date;

/**
 * 用户表
 */
public class User {
    private Integer id;//用户id
    private String userName;//用户名
    private String userPwd;//用户密码
    private String userKey;//用户密码秘钥
    private String userDealPwd;//用户支付密码
    private String userDealKey;//用户支付密码秘钥
    private Integer status;//用户状态
    private String userPhone;//用户手机号码
    private Date addTime;//用户添加时间
    private Date editTime;//用户编辑时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserDealPwd() {
        return userDealPwd;
    }

    public void setUserDealPwd(String userDealPwd) {
        this.userDealPwd = userDealPwd;
    }

    public String getUserDealKey() {
        return userDealKey;
    }

    public void setUserDealKey(String userDealKey) {
        this.userDealKey = userDealKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
}
