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
@Table(name = "gen_std_branch")
public class Branch {
	@Id
	 @GeneratedValue
	private Long slno;

	private String name;
	
	private String code;
	
	private Integer pincode;

	private String address;
	
	private String contactName;
	
	private String emailId;
	
	private String mobileNo;
	
	private String phoneNo;
	
	private String createdBy;

	private String modifiedBy;  

	private Time createdAt;

	private Time modifiedAt;
	
	private Boolean isActive;
	
	private String city;
		
	@ManyToOne( optional = false)
	@JoinColumn(name = "state_slno", nullable = false)
	private State state;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "district_slno", nullable = false)
	private District district;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "taluk_slno", nullable = false)
	private Taluk taluk;
	
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Taluk getTaluk() {
		return taluk;
	}

	public void setTaluk(Taluk taluk) {
		this.taluk = taluk;
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
		return "Branch [slno=" + slno + ", name=" + name + ", code=" + code + ", pincode=" + pincode + ", address="
				+ address + ", contactName=" + contactName + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", phoneNo=" + phoneNo + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdAt="
				+ createdAt + ", modifiedAt=" + modifiedAt + ", isActive=" + isActive + ", city=" + city + ", state="
				+ state + ", district=" + district + ", taluk=" + taluk + ", createdOn=" + createdOn + ", modifiedOn="
				+ modifiedOn + "]";
	}

    

}
