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
@Table(name = "gen_std_share_parameter")
public class ShareParameter {

	@Id
	@GeneratedValue
	private Long slno;	
	private Float shareValue;
	private Integer minShare;
	private Integer maxShare;
	private Float dividendDeclared;
	private String createdBy;

	private String modifiedBy;  
	

	@Column(name = "created_on", columnDefinition = "DATE")
	private Date createdOn;


	private Time createdAt;
	 
	private Time modifiedAt;


    @Column(name = "modified_on", columnDefinition = "DATE")
	private Date modifiedOn;

    @ManyToOne( optional = false)
	@JoinColumn(name = "memberType_slno", nullable = false)
	private MemberType memberType;

    private Boolean isActive;
    private Boolean isDelete;
    
	public Long getSlno() {
		return slno;
	}
	public void setSlno(Long slno) {
		this.slno = slno;
	}
	public Float getShareValue() {
		return shareValue;
	}
	public void setShareValue(Float shareValue) {
		this.shareValue = shareValue;
	}
	public Integer getMinShare() {
		return minShare;
	}
	public void setMinShare(Integer minShare) {
		this.minShare = minShare;
	}
	public Integer getMaxShare() {
		return maxShare;
	}
	public void setMaxShare(Integer maxShare) {
		this.maxShare = maxShare;
	}
	public Float getDividendDeclared() {
		return dividendDeclared;
	}
	public void setDividendDeclared(Float dividendDeclared) {
		this.dividendDeclared = dividendDeclared;
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
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
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
		return "ShareParameter [slno=" + slno + ", shareValue=" + shareValue + ", minShare=" + minShare + ", maxShare="
				+ maxShare + ", dividendDeclared=" + dividendDeclared + ", createdBy=" + createdBy + ", modifiedBy="
				+ modifiedBy + ", createdOn=" + createdOn + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", modifiedOn=" + modifiedOn + ", memberType=" + memberType + ", isActive=" + isActive
				+ ", isDelete=" + isDelete + "]";
	}
    
    
	}