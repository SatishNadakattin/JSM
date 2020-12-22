package com.app.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gen_std_compounding_period")
public class CompoundingPeriod {

	@Id
	@GeneratedValue
	private Long slno;
	private String name;
	
	private String createdBy;
	private String modifiedBy;
	
	private Time createdAt;
	private Time modifiedAt;
	
	@Column(name = "created_on", columnDefinition = "DATE")
	private Date createdOn;
	
	@Column(name = "modified_on", columnDefinition = "DATE")
	private Date modifiedOn;

	 private Boolean isActive;
	 private Boolean isDelete;
	 
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
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Time getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}
	public Time getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Time modifiedAt) {
		this.modifiedAt = modifiedAt;
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
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "CompoundingPeriod [slno=" + slno + ", name=" + name + ", createdBy=" + createdBy + ", modifiedBy="
				+ modifiedBy + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}
	 
	 
}
