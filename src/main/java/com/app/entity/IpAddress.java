package com.app.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="gen_std_ipAddress")
public class IpAddress {
	
	
	@Id
	 @GeneratedValue
	private Long slno;

	private String ipAddress;
	
	private Boolean isActive;
	
	private String createdBy;

	private String modifiedBy;  
	
	@Column(name = "created_on", columnDefinition = "DATE")
	private Date createdOn;

	private Time createdAt;
	
   @Column(name = "modified_on", columnDefinition = "DATE")
	private Date modifiedOn;
	
	private Time modifiedAt;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "branch_slno", nullable = false)
	private Branch branch;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Time getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Time modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "IpAddress [slno=" + slno + ", ipAddress=" + ipAddress + ", isActive=" + isActive + ", createdBy="
				+ createdBy + ", modifiedBy=" + modifiedBy + ", createdOn=" + createdOn + ", createdAt=" + createdAt
				+ ", modifiedOn=" + modifiedOn + ", modifiedAt=" + modifiedAt + ", branch=" + branch + "]";
	}


	
	
}
