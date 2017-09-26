package com.buy.tsg.entity;

import java.util.Date;

public class AuthApplyMessage {
    private Integer id;

    private String applyName;

    private String applyTelphone;

    private String submitName;

    private String submitTelphone;

    private Date submitTime;

    private Byte status;
	
	private String beizhu;

    private String defeatmessage;

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

    public String getDefeatmessage() {
        return defeatmessage;
    }

    public void setDefeatmessage(String defeatmessage) {
        this.defeatmessage = defeatmessage == null ? null : defeatmessage.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
    }

    public String getApplyTelphone() {
        return applyTelphone;
    }

    public void setApplyTelphone(String applyTelphone) {
        this.applyTelphone = applyTelphone == null ? null : applyTelphone.trim();
    }

    public String getSubmitName() {
        return submitName;
    }

    public void setSubmitName(String submitName) {
        this.submitName = submitName == null ? null : submitName.trim();
    }

    public String getSubmitTelphone() {
        return submitTelphone;
    }

    public void setSubmitTelphone(String submitTelphone) {
        this.submitTelphone = submitTelphone == null ? null : submitTelphone.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}