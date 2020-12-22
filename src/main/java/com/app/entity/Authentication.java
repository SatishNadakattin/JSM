package com.app.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gen_std_authentication")
public class Authentication {
	
	@Id
	@GeneratedValue
	private Long slno;
	
	private String username;
	
	private String password;

	private Time createdAt;
	
	@Column(name = "created_on", columnDefinition = "DATE")
	private Date createdOn;
	
	private String loginType;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Time getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	@Override
	public String toString() {
		return "Authentication [slno=" + slno + ", username=" + username + ", password=" + password + ", createdAt="
				+ createdAt + ", createdOn=" + createdOn + ", loginType=" + loginType + "]";
	}
	
	
	
	
	
}
	

