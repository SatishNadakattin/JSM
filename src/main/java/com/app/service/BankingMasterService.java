package com.app.service;

import java.util.List;

import com.app.request.BankingMasterRequest;

public interface BankingMasterService {

	
	public String saveRelationship(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object getRelationship() throws Exception;

	public Object getRelationshipBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;;

	public Object updateRelationship(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteRelationship(BankingMasterRequest bankingMasterRequest) throws Exception;

//	MemberType
	
	public Object createMemberType(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object getMemberType()throws Exception;

	public Object getMemberTypeBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object updateMemberType(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteMemberType(BankingMasterRequest bankingMasterRequest) throws Exception;
	
// Share Parameters
	
	public Object createShareParameter(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object getShareParameter() throws Exception;

	public Object getShareParameterBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object updateShareParameter(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteShareParameter(BankingMasterRequest bankingMasterRequest) throws Exception;

// fee_parameter

	public Object createFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object getFeeParameter() throws Exception;

	public Object getFeeParameterBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object updateFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception;

//	SB_Type
	
	public Object createSbType(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object getSbType() throws Exception;

	public Object getSbTypeBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object updateSbType(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteSbType(BankingMasterRequest bankingMasterRequest) throws Exception;
	
//	SB Accounts Parameters

	public Object createSbAccountsParameters(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object getSbAccountsParameters() throws Exception;

	public Object getSbAccountsParametersBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object updateSbAccountsParameters(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteSbAccountsParameters(BankingMasterRequest bankingMasterRequest) throws Exception;
	
//	Deposit_Type

	public Object createDepositType(BankingMasterRequest bankingMasterRequest)throws Exception;

	public Object getDepositType() throws Exception;

	public Object getDepositTypeBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object updateDepositType(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteDepositType(BankingMasterRequest bankingMasterRequest) throws Exception;

//	Compounding_period
	
	public Object createCompoundingPeriod(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object getCompoundingPeriod() throws Exception;

	public Object getCompoundingPeriodBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object updateCompoundingPeriod(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteCompoundingPeriod(BankingMasterRequest bankingMasterRequest) throws Exception;

//	Holiday_list
	
	public Object createHolidayList(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object getHolidayList() throws Exception;

	public Object getHolidayListBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object updateHolidayList(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteHolidayList(BankingMasterRequest bankingMasterRequest) throws Exception;
	
//	Late_fee_parameter

	public Object createLateFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object getLateFeeParameter() throws Exception;

	public Object getlateFeeParameterBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object updateLateFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteLateFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception;

//	charges
	
	public Object createCharges(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object getCharges() throws Exception;

	public Object getChargesBySlno(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object updateCharges(BankingMasterRequest bankingMasterRequest) throws Exception;

	public Object deleteCharges(BankingMasterRequest bankingMasterRequest) throws Exception;

	
}
