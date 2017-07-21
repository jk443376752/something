package com.buy.tsg.entity;

import java.util.Date;

public class LoginUser {
    private Integer id;

    private String username;

    private String password;

    private Byte sex;

    private String age;

    private Date createtime;

    private Date logintime;

    private String ip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", age="
				+ age + ", createtime=" + createtime + ", logintime=" + logintime + ", ip=" + ip + "]";
	}
    
}