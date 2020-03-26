package com.drawdream.app.admin.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Admin {
    public int id;
    public String adminName;
    public String adminPwd;
    public String adminKey;
    public String adminActionPwd;
    public String adminActionKey;
    public String adminPhone;
    public String adminToken;
    //    public Rule Rule;
//    @DateTimeFormat('yyyy-DD-mm')
    public Date addTime;
    public Date editTime;

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
