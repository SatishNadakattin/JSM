package com.app.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gen_std_sb_accounts_parameters")
public class SbAccountsParameters {

	@Id
	@GeneratedValue
	private Long slno;

	@ManyToOne(optional = false)
	@JoinColumn(name = "branch_slno", nullable = false)
	private Branch branch;

	@ManyToOne(optional = false)
	@JoinColumn(name = "sbType_slno", nullable = false)
	private SbType sbType;
	
	private BigDecimal sbMinBalance;
	
	private BigDecimal sbMaxBalance;
	
	private BigDecimal sbRoi;
	
	private BigDecimal sbMinPeriod;
	
	private BigDecimal serviceCharge;
	
	private BigDecimal penalty;
	
	private BigDecimal sbMinBalWithCheqBookForStaff;
	
	private BigDecimal sbMinBalWithoutCheqBookForStaff;
	
	private BigDecimal sbRoiForStaff;

	private String createdBy;

	private String modifiedBy;

	@Column(name = "created_on", columnDefinition = "DATE")
	private Date createdOn;

	private Time createdAt;

	private Time modifiedAt;

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
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public SbType getSbType() {
		return sbType;
	}
	public void setSbType(SbType sbType) {
		this.sbType = sbType;
	}
	public BigDecimal getSbMinBalance() {
		return sbMinBalance;
	}
	public void setSbMinBalance(BigDecimal sbMinBalance) {
		this.sbMinBalance = sbMinBalance;
	}
	public BigDecimal getSbMaxBalance() {
		return sbMaxBalance;
	}
	public void setSbMaxBalance(BigDecimal sbMaxBalance) {
		this.sbMaxBalance = sbMaxBalance;
	}
	public BigDecimal getSbRoi() {
		return sbRoi;
	}
	public void setSbRoi(BigDecimal sbRoi) {
		this.sbRoi = sbRoi;
	}
	public BigDecimal getSbMinPeriod() {
		return sbMinPeriod;
	}
	public void setSbMinPeriod(BigDecimal sbMinPeriod) {
		this.sbMinPeriod = sbMinPeriod;
	}
	public BigDecimal getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(BigDecimal serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public BigDecimal getPenalty() {
		return penalty;
	}
	public void setPenalty(BigDecimal penalty) {
		this.penalty = penalty;
	}
	public BigDecimal getSbMinBalWithCheqBookForStaff() {
		return sbMinBalWithCheqBookForStaff;
	}
	public void setSbMinBalWithCheqBookForStaff(BigDecimal sbMinBalWithCheqBookForStaff) {
		this.sbMinBalWithCheqBookForStaff = sbMinBalWithCheqBookForStaff;
	}
	public BigDecimal getSbMinBalWithoutCheqBookForStaff() {
		return sbMinBalWithoutCheqBookForStaff;
	}
	public void setSbMinBalWithoutCheqBookForStaff(BigDecimal sbMinBalWithoutCheqBookForStaff) {
		this.sbMinBalWithoutCheqBookForStaff = sbMinBalWithoutCheqBookForStaff;
	}
	public BigDecimal getSbRoiForStaff() {
		return sbRoiForStaff;
	}
	public void setSbRoiForStaff(BigDecimal sbRoiForStaff) {
		this.sbRoiForStaff = sbRoiForStaff;
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
	public Time getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Time modifiedAt) {
		this.modifiedAt = modifiedAt;
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
		return "SbAccountsParameters [slno=" + slno + ", branch=" + branch + ", sbType=" + sbType + ", sbMinBalance="
				+ sbMinBalance + ", sbMaxBalance=" + sbMaxBalance + ", sbRoi=" + sbRoi + ", sbMinPeriod=" + sbMinPeriod
				+ ", serviceCharge=" + serviceCharge + ", penalty=" + penalty + ", sbMinBalWithCheqBookForStaff="
				+ sbMinBalWithCheqBookForStaff + ", sbMinBalWithoutCheqBookForStaff=" + sbMinBalWithoutCheqBookForStaff
				+ ", sbRoiForStaff=" + sbRoiForStaff + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", createdOn=" + createdOn + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", modifiedOn=" + modifiedOn + ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}
	 
	 
}
