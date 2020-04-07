package com.drawdream.app.admin.pojo;

import cn.hutool.core.date.DateTime;

import java.util.Date;

public class Log {
    private Integer id;
    private String logType;
    private String logContent;
    private Date addTime;
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(DateTime addTime) {
        this.addTime = addTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
