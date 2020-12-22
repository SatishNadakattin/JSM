package com.app.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gen_std_financial_year")
public class FinancialYear {
	
	@Id
	 @GeneratedValue
	private Long slno;

	private String fromYear;
	
	private String toYear;
	
	private String createdBy;

	private String modifiedBy;  
	
	private Time createdAt;
	
	private Time modifiedAt;

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

	public String getFromYear() {
		return fromYear;
	}

	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	public String getToYear() {
		return toYear;
	}

	public void setToYear(String toYear) {
		this.toYear = toYear;
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

	@Override
	public String toString() {
		return "FinancialYear [slno=" + slno + ", fromYear=" + fromYear + ", toYear=" + toYear + ", createdBy="
				+ createdBy + ", modifiedBy=" + modifiedBy + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
	}
	


}
