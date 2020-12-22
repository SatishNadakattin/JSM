package com.app.request;

import java.math.BigDecimal;

public class BankingMasterRequest {

	private Long slno;
	
	private Boolean isActive;
	
	private String relationshipCode;
	
	private String relationship;
	
	private String name;	
	
	private Float shareValue;
	
	private Integer minShare;
	
	private Integer maxShare;
	
	private Float dividendDeclared;	
		
	private Integer adminFee;
	
	private Integer deathFund;
	
	private Integer buldingFund;
	
//	SB Accounts Parameters
	
    private BigDecimal sbMinBalance;
	
	private BigDecimal sbMaxBalance;
	
	private BigDecimal sbRoi;
	
	private BigDecimal sbMinPeriod;
	
	private BigDecimal serviceCharge;
	
	private BigDecimal penalty;
	
	private BigDecimal sbMinBalWithCheqBookForStaff;
	
	private BigDecimal sbMinBalWithoutCheqBookForStaff;
	
	private BigDecimal sbRoiForStaff;
	
//	Holiday_list
	
	private String holidayDate;
	
	private String holidayName;
	
		
	private String createdBy;
	
	private String modifiedBy;
	
	private Long memberType;
	
	private Long sbType;
	
	private Long branch;
	
	private Long financialYear;
	
//	late_fee_parameter
	
	private BigDecimal lateFees;
	
	private Integer gracePeriod;
	
	private Long compoundingPeriod;
	
//	charges
	
	private String charges;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getRelationshipCode() {
		return relationshipCode;
	}

	public void setRelationshipCode(String relationshipCode) {
		this.relationshipCode = relationshipCode;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getAdminFee() {
		return adminFee;
	}

	public void setAdminFee(Integer adminFee) {
		this.adminFee = adminFee;
	}

	public Integer getDeathFund() {
		return deathFund;
	}

	public void setDeathFund(Integer deathFund) {
		this.deathFund = deathFund;
	}

	public Integer getBuldingFund() {
		return buldingFund;
	}

	public void setBuldingFund(Integer buldingFund) {
		this.buldingFund = buldingFund;
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

	public String getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(String holidayDate) {
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

	public Long getMemberType() {
		return memberType;
	}

	public void setMemberType(Long memberType) {
		this.memberType = memberType;
	}

	public Long getSbType() {
		return sbType;
	}

	public void setSbType(Long sbType) {
		this.sbType = sbType;
	}

	public Long getBranch() {
		return branch;
	}

	public void setBranch(Long branch) {
		this.branch = branch;
	}

	public Long getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(Long financialYear) {
		this.financialYear = financialYear;
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

	public Long getCompoundingPeriod() {
		return compoundingPeriod;
	}

	public void setCompoundingPeriod(Long compoundingPeriod) {
		this.compoundingPeriod = compoundingPeriod;
	}

	public String getCharges() {
		return charges;
	}

	public void setCharges(String charges) {
		this.charges = charges;
	}

	@Override
	public String toString() {
		return "BankingMasterRequest [slno=" + slno + ", isActive=" + isActive + ", relationshipCode="
				+ relationshipCode + ", relationship=" + relationship + ", name=" + name + ", shareValue=" + shareValue
				+ ", minShare=" + minShare + ", maxShare=" + maxShare + ", dividendDeclared=" + dividendDeclared
				+ ", adminFee=" + adminFee + ", deathFund=" + deathFund + ", buldingFund=" + buldingFund
				+ ", sbMinBalance=" + sbMinBalance + ", sbMaxBalance=" + sbMaxBalance + ", sbRoi=" + sbRoi
				+ ", sbMinPeriod=" + sbMinPeriod + ", serviceCharge=" + serviceCharge + ", penalty=" + penalty
				+ ", sbMinBalWithCheqBookForStaff=" + sbMinBalWithCheqBookForStaff
				+ ", sbMinBalWithoutCheqBookForStaff=" + sbMinBalWithoutCheqBookForStaff + ", sbRoiForStaff="
				+ sbRoiForStaff + ", holidayDate=" + holidayDate + ", holidayName=" + holidayName + ", createdBy="
				+ createdBy + ", modifiedBy=" + modifiedBy + ", memberType=" + memberType + ", sbType=" + sbType
				+ ", branch=" + branch + ", financialYear=" + financialYear + ", lateFees=" + lateFees
				+ ", gracePeriod=" + gracePeriod + ", compoundingPeriod=" + compoundingPeriod + ", charges=" + charges
				+ "]";
	}

	
}
