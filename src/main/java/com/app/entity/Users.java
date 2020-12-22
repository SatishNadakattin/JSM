package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

@Entity
@Table(name = "gen_std_users")
public class Users {

	@Id
	@GeneratedValue
	private long slno;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String mobile;
	@Column
	private String emailId;
	@Column
	private String address;
	@Column
	private String name;
	
	private String CreatedBy;

	private String ModifiedBy;  
	

	@Column(name = "created_on", columnDefinition = "DATE")
	private Date createdOn;


	private Time createdAt;
	

    @Column(name = "modified_on", columnDefinition = "DATE")
	private Date ModifiedOn;
	

 
	private Time ModifiedAt;

	
	
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public String getModifiedBy() {
		return ModifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Time getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}
	public Date getModifiedOn() {
		return ModifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		ModifiedOn = modifiedOn;
	}
	public Time getModifiedAt() {
		return ModifiedAt;
	}
	public void setModifiedAt(Time modifiedAt) {
		ModifiedAt = modifiedAt;
	}
	public long getSlno() {
		return slno;
	}
	public void setSlno(long slno) {
		this.slno = slno;
	}
	@Override
	public String toString() {
		return "Users [slno=" + slno + ", username=" + username + ", password=" + password + ", mobile=" + mobile
				+ ", emailId=" + emailId + ", address=" + address + ", name=" + name + ", CreatedBy=" + CreatedBy
				+ ", ModifiedBy=" + ModifiedBy + ", createdOn=" + createdOn + ", createdAt=" + createdAt
				+ ", ModifiedOn=" + ModifiedOn + ", ModifiedAt=" + ModifiedAt + "]";
	}
	
	





}