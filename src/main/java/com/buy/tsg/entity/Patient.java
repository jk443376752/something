package com.buy.tsg.entity;

import java.util.Date;

public class Patient {
    private Integer paId;

    private String paName;

    private String paStatus;

    private String paCaseHistory;

    private String paCaseHistoryNum;

    private Date paClinicTime;

    private Date paAppointmentTime;

    private String paDoctorName;

    private String paPhone;

    private String paAttendanceStatus;

    private Double paReceivable;

    private Double paNetReceipts;

    public Integer getPaId() {
        return paId;
    }

    public void setPaId(Integer paId) {
        this.paId = paId;
    }

    public String getPaName() {
        return paName;
    }

    public void setPaName(String paName) {
        this.paName = paName == null ? null : paName.trim();
    }

    public String getPaStatus() {
        return paStatus;
    }

    public void setPaStatus(String paStatus) {
        this.paStatus = paStatus == null ? null : paStatus.trim();
    }

    public String getPaCaseHistory() {
        return paCaseHistory;
    }

    public void setPaCaseHistory(String paCaseHistory) {
        this.paCaseHistory = paCaseHistory == null ? null : paCaseHistory.trim();
    }

    public String getPaCaseHistoryNum() {
        return paCaseHistoryNum;
    }

    public void setPaCaseHistoryNum(String paCaseHistoryNum) {
        this.paCaseHistoryNum = paCaseHistoryNum == null ? null : paCaseHistoryNum.trim();
    }

    public Date getPaClinicTime() {
        return paClinicTime;
    }

    public void setPaClinicTime(Date paClinicTime) {
        this.paClinicTime = paClinicTime;
    }

    public Date getPaAppointmentTime() {
        return paAppointmentTime;
    }

    public void setPaAppointmentTime(Date paAppointmentTime) {
        this.paAppointmentTime = paAppointmentTime;
    }

    public String getPaDoctorName() {
        return paDoctorName;
    }

    public void setPaDoctorName(String paDoctorName) {
        this.paDoctorName = paDoctorName == null ? null : paDoctorName.trim();
    }

    public String getPaPhone() {
        return paPhone;
    }

    public void setPaPhone(String paPhone) {
        this.paPhone = paPhone == null ? null : paPhone.trim();
    }

    public String getPaAttendanceStatus() {
        return paAttendanceStatus;
    }

    public void setPaAttendanceStatus(String paAttendanceStatus) {
        this.paAttendanceStatus = paAttendanceStatus == null ? null : paAttendanceStatus.trim();
    }

    public Double getPaReceivable() {
        return paReceivable;
    }

    public void setPaReceivable(Double paReceivable) {
        this.paReceivable = paReceivable;
    }

    public Double getPaNetReceipts() {
        return paNetReceipts;
    }

    public void setPaNetReceipts(Double paNetReceipts) {
        this.paNetReceipts = paNetReceipts;
    }
}