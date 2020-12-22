package com.app.entity;

import java.math.BigDecimal;
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
@Table(name = "gen_std_late_fee_parameter")
public class LateFeeParameter {

	@Id
	@GeneratedValue
	private Long slno;
	private BigDecimal lateFees;
	private Integer gracePeriod;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "compoundingPeriod_slno", nullable = false)
	private CompoundingPeriod compoundingPeriod;
	
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
	public BigDecimal getLateFees() {
		return lateFees;
	}
	public void setLateFees(BigDecimal lateFees) {
		this.lateFees = lateFees;
	}
	public Integer getGracePeriod() {
		return gracePeriod;
	}
	public void setGracePeriod(Integer gracePeriod) {
		this.gracePeriod = gracePeriod;
	}
	public CompoundingPeriod getCompoundingPeriod() {
		return compoundingPeriod;
	}
	public void setCompoundingPeriod(CompoundingPeriod compoundingPeriod) {
		this.compoundingPeriod = compoundingPeriod;
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
		return "LateFeeParameter [slno=" + slno + ", lateFees=" + lateFees + ", gracePeriod=" + gracePeriod
				+ ", compoundingPeriod=" + compoundingPeriod + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", createdOn=" + createdOn + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", modifiedOn=" + modifiedOn + ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}
	 
	 
}
