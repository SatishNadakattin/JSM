package com.app.request;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CommonRequest {
	
	private Long slno;
	
	private String name;
	
	private String createdBy;
	
	private String modifiedBy;
	
	private String type;
	
	private String description;

	private Long state;
	
	private Long district;
	
    private String title;
	
	private String active;
	
	private String newsDate;
	
    private String fromYear;
	
	private String toYear;
	
	private String code;
	
	private Integer pincode;
	
	
	private Integer pageNo ;
	
	private Integer pageSize;

	private String address;
	
	private String contactName;
	
	private String emailId;
	
	private String mobileNo;
	
	private String phoneNo;
	
	private String ipAddress;
	
	private String accountNo;
	
	private String username;
	
	private String password;
	
	
	private Boolean isActive;
	
	private Long branch;
	
	private Long serviceCenter;
	
	private Long country;
	
	private Long taluk;
	
	private String city;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Long getDistrict() {
		return district;
	}

	public void setDistrict(Long district) {
		this.district = district;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
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

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getBranch() {
		return branch;
	}

	public void setBranch(Long branch) {
		this.branch = branch;
	}

	public Long getServiceCenter() {
		return serviceCenter;
	}

	public void setServiceCenter(Long serviceCenter) {
		this.serviceCenter = serviceCenter;
	}

	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

	public Long getTaluk() {
		return taluk;
	}

	public void setTaluk(Long taluk) {
		this.taluk = taluk;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CommonRequest [slno=" + slno + ", name=" + name + ", createdBy=" + createdBy + ", modifiedBy="
				+ modifiedBy + ", type=" + type + ", description=" + description + ", state=" + state + ", district="
				+ district + ", title=" + title + ", active=" + active + ", newsDate=" + newsDate + ", fromYear="
				+ fromYear + ", toYear=" + toYear + ", code=" + code + ", pincode=" + pincode + ", pageNo=" + pageNo
				+ ", pageSize=" + pageSize + ", address=" + address + ", contactName=" + contactName + ", emailId="
				+ emailId + ", mobileNo=" + mobileNo + ", phoneNo=" + phoneNo + ", ipAddress=" + ipAddress
				+ ", accountNo=" + accountNo + ", username=" + username + ", password=" + password + ", isActive="
				+ isActive + ", branch=" + branch + ", serviceCenter=" + serviceCenter + ", country=" + country
				+ ", taluk=" + taluk + ", city=" + city + "]";
	}

	
}
