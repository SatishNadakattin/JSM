package com.app.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gen_std_holiday_list")
public class HolidayList {

	@Id
	@GeneratedValue
	private Long slno;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "branch_slno", nullable = false)
	private Branch branch;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "financialYear_slno", nullable = false)
	private FinancialYear financialYear;
	
	@Column(name = "holiday_date", columnDefinition = "DATE")
	private Date holidayDate; 
	
	private String holidayName;
	
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
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public FinancialYear getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(FinancialYear financialYear) {
		this.financialYear = financialYear;
	}
	public Date getHolidayDate() {
		return holidayDate;
	}
	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
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
		return "HolidayList [slno=" + slno + ", branch=" + branch + ", financialYear=" + financialYear
				+ ", holidayDate=" + holidayDate + ", holidayName=" + holidayName + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", isActive=" + isActive + ", isDelete="
				+ isDelete + "]";
	}
    
    
}
