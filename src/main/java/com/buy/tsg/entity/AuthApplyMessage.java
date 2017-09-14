package com.buy.tsg.entity;

import java.util.Date;

public class AuthApplyMessage {
    private Integer id;

    private String applyName;

    private String applySex;

    private String applyTelphone;

    private String applyDepartment;

    private String submitName;

    private String submitTelphone;

    private String submitDepartment;

    private Date submitTime;

    private Byte status;

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

    public String getApplySex() {
        return applySex;
    }

    public void setApplySex(String applySex) {
        this.applySex = applySex == null ? null : applySex.trim();
    }

    public String getApplyTelphone() {
        return applyTelphone;
    }

    public void setApplyTelphone(String applyTelphone) {
        this.applyTelphone = applyTelphone == null ? null : applyTelphone.trim();
    }

    public String getApplyDepartment() {
        return applyDepartment;
    }

    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment == null ? null : applyDepartment.trim();
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

    public String getSubmitDepartment() {
        return submitDepartment;
    }

    public void setSubmitDepartment(String submitDepartment) {
        this.submitDepartment = submitDepartment == null ? null : submitDepartment.trim();
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