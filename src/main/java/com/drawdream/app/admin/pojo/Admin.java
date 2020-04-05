package com.drawdream.app.admin.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * 管理员表
 */
public class Admin {
    private int id;//管理员id
    private String adminName;//管理员名字
    private String adminPwd;//管理员密码
    private String adminKey;//管理员密码秘钥
    private String adminActionPwd;//管理员操作密码
    private String adminActionKey;//管理员操作密码秘钥
    private String adminPhone;//管理员手机号码
    private String adminToken;//管理员唯一登录验证
    private Rulegroup rulegroup;
    private String headPortrait;
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date editTime;

    public Rulegroup getRulegroup() {
        return rulegroup;
    }

    public void setRulegroup(Rulegroup rulegroup) {
        this.rulegroup = rulegroup;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }

    public String getAdminActionPwd() {
        return adminActionPwd;
    }

    public void setAdminActionPwd(String adminActionPwd) {
        this.adminActionPwd = adminActionPwd;
    }

    public String getAdminActionKey() {
        return adminActionKey;
    }

    public void setAdminActionKey(String adminActionKey) {
        this.adminActionKey = adminActionKey;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
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

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminKey='" + adminKey + '\'' +
                ", adminActionPwd='" + adminActionPwd + '\'' +
                ", adminActionKey='" + adminActionKey + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", adminToken='" + adminToken + '\'' +
                ", addTime=" + addTime +
                ", editTime=" + editTime +
                '}';
    }
}
