package com.drawdream.app.admin.pojo;

//import cn.hutool.core.date.DateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 权限表
 */
public class Rule {
    private Integer id;
    private String ruleName;
    private String accessPath;
    private Integer needRule;
    private Integer type;
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date addTime;
    private String port;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminRuleName() {
        return ruleName;
    }

    public void setAdminRuleName(String adminRuleName) {
        this.ruleName = adminRuleName;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", ruleName='" + ruleName + '\'' +
                ", accessPath='" + accessPath + '\'' +
                ", needRule=" + needRule +
                ", type=" + type +
                ", addTime=" + addTime +
                ", port='" + port + '\'' +
                '}';
    }
}
