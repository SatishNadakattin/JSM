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
	@Table(name = "gen_std_service_center_user")
	public class ServiceCenterUser {
		@Id
		 @GeneratedValue
		private Long slno;

		private String accountNo;
		
		private String username;
		
		private String password;
		
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
		
		@ManyToOne( optional = false)
		@JoinColumn(name = "branch_slno", nullable = false)
		private Branch branch;
		
		@ManyToOne( optional = false)
		@JoinColumn(name = "service_center_slno", nullable = false)
		private ServiceCenter serviceCenter;
		
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

		public Branch getBranch() {
			return branch;
		}

		public void setBranch(Branch branch) {
			this.branch = branch;
		}

		public ServiceCenter getServiceCenter() {
			return serviceCenter;
		}

		public void setServiceCenter(ServiceCenter serviceCenter) {
			this.serviceCenter = serviceCenter;
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
			return "ServiceCenterUser [slno=" + slno + ", accountNo=" + accountNo + ", username=" + username
					+ ", password=" + password + ", pincode=" + pincode + ", address=" + address + ", contactName="
					+ contactName + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", phoneNo=" + phoneNo
					+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdAt=" + createdAt
					+ ", modifiedAt=" + modifiedAt + ", branch=" + branch + ", serviceCenter=" + serviceCenter
					+ ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
		}

	    
	    

}
