package com.me.boliplate_mvvm.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FCMResponse {
    @SerializedName("key1")
    @Expose
    private int key1;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("notificationSubType")
    @Expose
    private String notificationSubType;
    @SerializedName("key2")
    @Expose
    private int key2;
    @SerializedName("lead_name")
    @Expose
    private String lead_name;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("updatestage")
    @Expose
    private int updatestage;
    @SerializedName("meeting_status")
    @Expose
    private int meeting_status;
    @SerializedName("request_status")
    @Expose
    private int request_status;
    @SerializedName("lead_id")
    @Expose
    private int lead_id;
    @SerializedName("remark_id")
    @Expose
    private int remark_id;

    public String getNotificationSubType() {
        return notificationSubType;
    }

    public void setNotificationSubType(String notificationSubType) {
        this.notificationSubType = notificationSubType;
    }

    public String getNotificationType() {
        return type;
    }

    public void setNotificationType(String notificationType) {
        this.type = notificationType;
    }

    public int getKey1() {
        return key1;
    }

    public void setKey1(int key1) {
        this.key1 = key1;
    }

    public int getKey2() {
        return key2;
    }

    public void setKey2(int key2) {
        this.key2 = key2;
    }

    public int getRequest_status() {
        return request_status;
    }

    public void setRequest_status(int request_status) {
        this.request_status = request_status;
    }

    public int getMeeting_status() {
        return meeting_status;
    }

    public void setMeeting_status(int meeting_status) {
        this.meeting_status = meeting_status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getUpdatestage() {
        return updatestage;
    }

    public void setUpdatestage(int updatestage) {
        this.updatestage = updatestage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLead_name() {
        return lead_name;
    }

    public void setLead_name(String lead_name) {
        this.lead_name = lead_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLead_id() {
        return lead_id;
    }

    public void setLead_id(int lead_id) {
        this.lead_id = lead_id;
    }

    public int getRemark_id() {
        return remark_id;
    }

    public void setRemark_id(int remark_id) {
        this.remark_id = remark_id;
    }


}
