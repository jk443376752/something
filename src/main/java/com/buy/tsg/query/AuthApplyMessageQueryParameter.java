package com.buy.tsg.query;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthApplyMessageQueryParameter extends BaseQueryParemeter {
	
	private String queryapplyname;
	
	private String queryapplyphone;
	
	private String querysubmitname;
	
	private String querysubmitphone;

	private Date starttime ;

	private Date endtime ;
	
	public String getQueryapplyname() {
		return queryapplyname;
	}
	public void setQueryapplyname(String queryapplyname) {
		this.queryapplyname = queryapplyname;
	}
	public String getQueryapplyphone() {
		return queryapplyphone;
	}
	public void setQueryapplyphone(String queryapplyphone) {
		this.queryapplyphone = queryapplyphone;
	}
	public String getQuerysubmitname() {
		return querysubmitname;
	}
	public void setQuerysubmitname(String querysubmitname) {
		this.querysubmitname = querysubmitname;
	}
	public String getQuerysubmitphone() {
		return querysubmitphone;
	}
	public void setQuerysubmitphone(String querysubmitphone) {
		this.querysubmitphone = querysubmitphone;
	}
	
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "AuthApplyMessageQueryParameter [queryapplyname=" + queryapplyname + ", queryapplyphone="
				+ queryapplyphone + ", querysubmitname=" + querysubmitname + ", querysubmitphone=" + querysubmitphone
				+ ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}
	
}
