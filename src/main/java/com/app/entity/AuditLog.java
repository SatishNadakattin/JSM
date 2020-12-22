package com.app.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gen_std_audit_log")
public class AuditLog {
	
	@Id
	@GeneratedValue
	private Long slno;
	private Integer status;
	private String logedBy;
	private Date logedDate;
	private Time logedTime;
	private String description;
	
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "modules_slno", nullable = false)
	private Modules modules;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "features_slno", nullable = false)
	private Features features;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLogedBy() {
		return logedBy;
	}

	public void setLogedBy(String logedBy) {
		this.logedBy = logedBy;
	}

	public Date getLogedDate() {
		return logedDate;
	}

	public void setLogedDate(Date logedDate) {
		this.logedDate = logedDate;
	}

	public Time getLogedTime() {
		return logedTime;
	}

	public void setLogedTime(Time logedTime) {
		this.logedTime = logedTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Modules getModules() {
		return modules;
	}

	public void setModules(Modules modules) {
		this.modules = modules;
	}

	public Features getFeatures() {
		return features;
	}

	public void setFeatures(Features features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "AuditLog [slno=" + slno + ", status=" + status + ", logedBy=" + logedBy + ", logedDate=" + logedDate
				+ ", logedTime=" + logedTime + ", description=" + description + ", modules=" + modules + ", features="
				+ features + "]";
	}

	
	
}
