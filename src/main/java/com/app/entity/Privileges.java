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
@Table(name = "gen_std_privileges")
public class Privileges {

	@Id
	@GeneratedValue
	private Long slno;
	
	private Boolean view;
	
	private Boolean create;
	
	private Boolean update;

	private Boolean delete;
	
	private Boolean isActive;
	
	private String createdBy;

	private String modifiedBy;  
	
	private Time modifiedAt;
	
	private Time createdAt;

	@Column(name = "created_on", columnDefinition = "DATE")
	private Date createdOn;

    @Column(name = "modified_on", columnDefinition = "DATE")
	private Date modifiedOn;
    
    @ManyToOne( optional = false)
	@JoinColumn(name = "modules_slno", nullable = false)
	private Modules modules;
    
    @ManyToOne( optional = false)
   	@JoinColumn(name = "features_slno", nullable = false)
   	private Features features;
    
    @ManyToOne( optional = false)
   	@JoinColumn(name = "roles_slno", nullable = false)
   	private Roles roles;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public Boolean getView() {
		return view;
	}

	public void setView(Boolean view) {
		this.view = view;
	}

	public Boolean getCreate() {
		return create;
	}

	public void setCreate(Boolean create) {
		this.create = create;
	}

	public Boolean getUpdate() {
		return update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
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

	public Modules getModules() {
		return modules;
	}

	public void setModules(Modules modules) {
		this.modules = modules;
	}


	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Features getFeatures() {
		return features;
	}

	public void setFeatures(Features features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "Privileges [slno=" + slno + ", view=" + view + ", create=" + create + ", update=" + update + ", delete="
				+ delete + ", isActive=" + isActive + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", modifiedAt=" + modifiedAt + ", createdAt=" + createdAt + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + ", modules=" + modules + ", features=" + features + ", roles=" + roles
				+ "]";
	}

	
	
}
