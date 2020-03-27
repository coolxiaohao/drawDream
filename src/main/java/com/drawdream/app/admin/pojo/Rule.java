package com.drawdream.app.admin.pojo;

import cn.hutool.core.date.DateTime;

/**
 * 权限表
 */
public class Rule {
    private Integer id;//权限id
    private String adminRuleName;
    private String accessPath;
    private Integer needRule;
    private Integer type;
    private DateTime addTime;
    private String port;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminRuleName() {
        return adminRuleName;
    }

    public void setAdminRuleName(String adminRuleName) {
        this.adminRuleName = adminRuleName;
    }

    public String getAccessPath() {
        return accessPath;
    }

    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath;
    }

    public Integer getNeedRule() {
        return needRule;
    }

    public void setNeedRule(Integer needRule) {
        this.needRule = needRule;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public DateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(DateTime addTime) {
        this.addTime = addTime;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
