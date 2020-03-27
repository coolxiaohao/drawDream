package com.drawdream.app.admin.pojo;

import cn.hutool.core.date.DateTime;

public class Rulegroup {
    private Integer id;
    private String groupName;
    private Integer type;
    private String ruleGroup;
    private Integer isDefault;
    private DateTime addTime;
    private DateTime editTime;
    private Rule rule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRuleGroup() {
        return ruleGroup;
    }

    public void setRuleGroup(String ruleGroup) {
        this.ruleGroup = ruleGroup;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public DateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(DateTime addTime) {
        this.addTime = addTime;
    }

    public DateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(DateTime editTime) {
        this.editTime = editTime;
    }
}
