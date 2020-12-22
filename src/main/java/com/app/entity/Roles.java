package com.app.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="gen_std_roles")
public class Roles {

	

	@Id
	@GeneratedValue
	private Long slno;

	private String name;
	
	private String createdBy;
	
	private Boolean isActive;

	private String modifiedBy;  
	
	private Time modifiedAt;
	
	private Time createdAt;

	@Column(name = "created_on", columnDefinition = "DATE")
	private Date createdOn;

    @Column(name = "modified_on", columnDefinition = "DATE")
	private Date modifiedOn;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Time getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Time modifiedAt) {
		this.modifiedAt = modifiedAt;
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

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		return "Roles [slno=" + slno + ", name=" + name + ", createdBy=" + createdBy + ", isActive=" + isActive
				+ ", modifiedBy=" + modifiedBy + ", modifiedAt=" + modifiedAt + ", createdAt=" + createdAt
				+ ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
	}
	

 
	

	
	
}
