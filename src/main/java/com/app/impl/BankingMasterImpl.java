package com.app.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Branch;
import com.app.entity.Charges;
import com.app.entity.CompoundingPeriod;
import com.app.entity.DepositType;
import com.app.entity.FeeParameter;
import com.app.entity.FinancialYear;
import com.app.entity.HolidayList;
import com.app.entity.LateFeeParameter;
import com.app.entity.MemberType;
import com.app.entity.Relationship;
import com.app.entity.SbAccountsParameters;
import com.app.entity.SbType;
import com.app.entity.ShareParameter;
import com.app.exception.BankRestException.DELETE_FAILED;
import com.app.exception.BankRestException.DUPLICATE_KEY;
import com.app.exception.BankRestException.NOT_FOUND;
import com.app.exception.BankRestException.UPDATE_FAILED;
import com.app.request.BankingMasterRequest;
import com.app.service.BankingMasterService;
import com.app.util.AutoManager;
import com.app.util.CommonApis;

@Service
public class BankingMasterImpl extends AutoManager implements BankingMasterService {

	private static Logger logger = LoggerFactory.getLogger("master-log");
	private Relationship bankingMasterRequest;

	@Autowired
	public CommonApis commonApis;	
	
	@Override
	public String saveRelationship(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Relationship" + bankingMasterRequest);
		List<Relationship> val = super.relationship.findByRelationshipAndIsDelete(false,bankingMasterRequest.getRelationship());
		if (val.size() > 0) {
			throw new DUPLICATE_KEY("Relationshipe already  exists");
		}
		Date date = new Date();
		Relationship data = new Relationship();
		data.setRelationshipCode(bankingMasterRequest.getRelationshipCode());
		data.setRelationship(bankingMasterRequest.getRelationship());
		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());
		data.setIsActive(true);
		data.setIsDelete(false);
		super.relationship.save(data);
		logger.info("Relationship created successfully" + data);
		commonApis.createAuditLog( 447L ,449L ,bankingMasterRequest.getCreatedBy(),"Save_Relationship",1);
		return "Relationship created successfully";
	}

	@Override
	public Object getRelationship() throws Exception {
		Iterable<Relationship> list = super.relationship.findByIsDelete(false);
		return list;
	}

	@Override
	public Object getRelationshipBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Relationship" + bankingMasterRequest);
		Optional<Relationship> list = super.relationship.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (!list.isPresent()) {
			throw new NOT_FOUND("Relationship is not present");
		}
		return list;
	}

	@Override
	public Object updateRelationship(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Relationship" + bankingMasterRequest);
		Optional<Relationship> data = super.relationship.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Relationship is not present");
		}
		List<Relationship> tasks = new ArrayList<Relationship>();
		tasks = super.relationship.findByRelationshipAndIsDelete(false,bankingMasterRequest.getRelationship().trim());
		if (tasks.size() > 0 && tasks.get(0).getSlno() != bankingMasterRequest.getSlno()) {
			throw new NOT_FOUND("Relationship already exists");
		}
		Date date = new Date();
		int retval = super.relationship.updateRelationshipRecord(bankingMasterRequest.getRelationshipCode(),
				bankingMasterRequest.getRelationship(), bankingMasterRequest.getModifiedBy(),
				new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()),bankingMasterRequest.getIsActive(), bankingMasterRequest.getSlno());
		if (retval == 1) {
			commonApis.createAuditLog( 447L ,449L ,bankingMasterRequest.getModifiedBy(),"updateRelationship",2);

			return "Relationship updated successfully";
		}
		throw new NOT_FOUND("Relationship  not present");
	}

	@Override
	public Object deleteRelationship(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Relationship" + bankingMasterRequest);
		
		Optional<Relationship> data = super.relationship.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Relationship is not present");
		}
		int retval = super.relationship.deleteRelationshipRecord(true,bankingMasterRequest.getSlno());
		if (retval == 1) {		
			commonApis.createAuditLog( 447L ,449L ,bankingMasterRequest.getModifiedBy(),"deleteRelationship",3);
			return "Relationship deleted successfully";
		}
		throw new NOT_FOUND("Relationship  not present");
	}
//	memberType

	@Override
	public String createMemberType(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside MemberType" + bankingMasterRequest);
		List<MemberType> val = super.memberType.findByNameAndIsDelete(false,bankingMasterRequest.getName());
		if (val.size() > 0) {
			throw new DUPLICATE_KEY("MemberType already  exists");
		}
		Date date = new Date();
		MemberType data = new MemberType();
		data.setName(bankingMasterRequest.getName());
		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());
		data.setIsActive(bankingMasterRequest.getIsActive());
		data.setIsActive(true);
		data.setIsDelete(false);
		super.memberType.save(data);
		logger.info("MemberType created successfully" + data);
		return "MemberType created successfully";
	}

	@Override
	public Object getMemberType() throws Exception {
		Iterable<MemberType> list = super.memberType.findByIsDelete(false);
		return list;
	}

	@Override
	public Object getMemberTypeBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Relationship" + bankingMasterRequest);
		Optional<MemberType> list = super.memberType.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (!list.isPresent()) {
			throw new NOT_FOUND("MemberType is not present");
		}
		return list;
	}

	@Override
	public Object updateMemberType(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Relationship" + bankingMasterRequest);
		Optional<MemberType> data = super.memberType.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("MemberType is not present");
		}
		List<MemberType> tasks = new ArrayList<MemberType>();
		tasks = super.memberType.findByNameAndIsDelete(false,bankingMasterRequest.getName().trim());
		if (tasks.size() > 0 && tasks.get(0).getSlno() != bankingMasterRequest.getSlno()) {
			throw new NOT_FOUND("MemberType already exists");
		}
		Date date = new Date();
		int retval = super.memberType.updateMemberTypeRecord(bankingMasterRequest.getName(),
				bankingMasterRequest.getModifiedBy(), new java.sql.Date(date.getTime()),
				new java.sql.Time(date.getTime()),bankingMasterRequest.getIsActive(), bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "MemberType updated successfully";
		}
		throw new NOT_FOUND("MemberType  not present");
	}

	@Override
	public Object deleteMemberType(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Relationship" + bankingMasterRequest);
		Optional<MemberType> data = super.memberType.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("MemberType is not present");
		}
		int retval = super.memberType.deleteMemberTypeRecord(true,bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "MemberType deleted successfully";
		}
		throw new NOT_FOUND("MemberType  not present");
	}
//share_parameter

	@Override
	public String createShareParameter(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside ShareParameter" + bankingMasterRequest);

		Optional<MemberType> datas = super.memberType.findBySlnoAndIsDelete(false,bankingMasterRequest.getMemberType());
		if (bankingMasterRequest.getMemberType() == null || !datas.isPresent()) {
			throw new NOT_FOUND("MemberType is not present");
		}
		Optional<ShareParameter> tasks = super.shareParameter
				.findByMemberTypeSlnoAndIsDelete(false,bankingMasterRequest.getMemberType());
		if (bankingMasterRequest.getMemberType() == null || tasks.isPresent()) {
			throw new DUPLICATE_KEY("ShareParameter already  exists");
		}
		Date date = new Date();
		ShareParameter data = new ShareParameter();
		data.setMemberType(datas.get());
		data.setShareValue(bankingMasterRequest.getShareValue());
		data.setMinShare(bankingMasterRequest.getMinShare());
		data.setMaxShare(bankingMasterRequest.getMaxShare());
		data.setDividendDeclared(bankingMasterRequest.getDividendDeclared());
		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());
		data.setIsActive(bankingMasterRequest.getIsActive());
		data.setIsActive(true);
		data.setIsDelete(false);
		super.shareParameter.save(data);
		logger.info("ShareParameter created successfully" + data);
		return "ShareParameter created successfully";
	}

	@Override
	public Object getShareParameter() throws Exception {
		LinkedList<Object> datalist = new LinkedList();

		Iterable<ShareParameter> list = super.shareParameter.findByIsDelete(false);
		for (ShareParameter t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("shareValue", t.getShareValue());
			result.put("minShare", t.getMinShare());
			result.put("maxShare", t.getMaxShare());
			result.put("dividendDeclared", t.getDividendDeclared());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("memberTypeSlno", t.getMemberType().getSlno());
			result.put("memberTypeName", t.getMemberType().getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object getShareParameterBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside ShareParameter" + bankingMasterRequest);
		LinkedList<Object> datalist = new LinkedList();

		Iterable<ShareParameter> list = super.shareParameter.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		for (ShareParameter t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("shareValue", t.getShareValue());
			result.put("minShare", t.getMinShare());
			result.put("maxShare", t.getMaxShare());
			result.put("dividendDeclared", t.getDividendDeclared());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("memberTypeSlno", t.getMemberType().getSlno());
			result.put("memberTypeName", t.getMemberType().getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object updateShareParameter(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside ShareParameter" + bankingMasterRequest);

		Optional<ShareParameter> data = super.shareParameter.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("ShareParameter is not present");
		}
		Date date = new Date();
		int retval = super.shareParameter.updateShareParameterRecord(bankingMasterRequest.getMemberType(),
				bankingMasterRequest.getShareValue(), bankingMasterRequest.getMinShare(),
				bankingMasterRequest.getMaxShare(), bankingMasterRequest.getDividendDeclared(),
				bankingMasterRequest.getModifiedBy(), new java.sql.Date(date.getTime()),
				new java.sql.Time(date.getTime()),bankingMasterRequest.getIsActive(), bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "ShareParameter updated successfully";
		}
		throw new NOT_FOUND("ShareParameter  not present");
	}

	@Override
	public Object deleteShareParameter(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Relationship" + bankingMasterRequest);
		Optional<ShareParameter> data = super.shareParameter.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("ShareParameter is not present");
		}
		int retval = super.shareParameter.deleteShareParameterRecord(true,bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "ShareParameter deleted successfully";
		}
		throw new NOT_FOUND("ShareParameter  not present");
	}

//	fee Parameter

	@Override
	public String createFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside FeeParameter" + bankingMasterRequest);

		Optional<MemberType> datas = super.memberType.findBySlnoAndIsDelete(false,bankingMasterRequest.getMemberType());
		if (bankingMasterRequest.getMemberType() == null || !datas.isPresent()) {
			throw new NOT_FOUND("MemberType is not present");
		}
		Optional<FeeParameter> tasks = super.feeParameter.findByMemberTypeSlnoAndIsDelete(false,bankingMasterRequest.getMemberType());
		if (bankingMasterRequest.getMemberType() == null || tasks.isPresent()) {
			throw new DUPLICATE_KEY("FeeParameter already  exists");
		}
		Date date = new Date();
		FeeParameter data = new FeeParameter();
		data.setMemberType(datas.get());
		data.setShareValue(bankingMasterRequest.getShareValue());
		data.setAdminFee(bankingMasterRequest.getAdminFee());
		data.setDeathFund(bankingMasterRequest.getDeathFund());
		data.setBuldingFund(bankingMasterRequest.getBuldingFund());
		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());
		data.setIsActive(true);		
		data.setIsDelete(false);
		super.feeParameter.save(data);
		logger.info("FeeParameter created successfully" + data);
		return "FeeParameter created successfully";
	}

	@Override
	public Object getFeeParameter() throws Exception {
		LinkedList<Object> datalist = new LinkedList();

		Iterable<FeeParameter> list = super.feeParameter.findByIsDelete(false);
		for (FeeParameter t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("shareValue", t.getShareValue());
			result.put("adminFee", t.getAdminFee());
			result.put("deathFund", t.getDeathFund());
			result.put("buldingFund", t.getBuldingFund());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("memberTypeSlno", t.getMemberType().getSlno());
			result.put("memberTypeName", t.getMemberType().getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object getFeeParameterBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside FeeParameter" + bankingMasterRequest);
		LinkedList<Object> datalist = new LinkedList();

		Iterable<FeeParameter> list = super.feeParameter.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		for (FeeParameter t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("shareValue", t.getShareValue());
			result.put("adminFee", t.getAdminFee());
			result.put("deathFund", t.getDeathFund());
			result.put("buldingFund", t.getBuldingFund());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("memberTypeSlno", t.getMemberType().getSlno());
			result.put("memberTypeName", t.getMemberType().getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object updateFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside FeeParameter" + bankingMasterRequest);

		Optional<FeeParameter> data = super.feeParameter.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("FeeParameter is not present");
		}
		Date date = new Date();
		int retval = super.feeParameter.updateFeeParameterRecord(bankingMasterRequest.getMemberType(),
				bankingMasterRequest.getShareValue(), bankingMasterRequest.getAdminFee(),
				bankingMasterRequest.getDeathFund(), bankingMasterRequest.getBuldingFund(),
				bankingMasterRequest.getModifiedBy(), new java.sql.Date(date.getTime()),
				new java.sql.Time(date.getTime()),bankingMasterRequest.getIsActive(), bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "FeeParameter updated successfully";
		}
		throw new NOT_FOUND("FeeParameter  not present");
	}

	@Override
	public Object deleteFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside FeeParameter" + bankingMasterRequest);
		Optional<FeeParameter> data = super.feeParameter.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("FeeParameter is not present");
		}
		int retval = super.feeParameter.deleteFeeParameterRecord(true,bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "FeeParameter deleted successfully";
		}
		throw new NOT_FOUND("FeeParameter  not present");
	}

//	SB_Type

	@Override
	public String createSbType(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside SbType" + bankingMasterRequest);
		List<SbType> val = super.sbType.findByNameAndIsDelete(false,bankingMasterRequest.getName());
		if (val.size() > 0) {
			throw new DUPLICATE_KEY("SB Type already  exists");
		}
		Date date = new Date();
		SbType data = new SbType();
		data.setName(bankingMasterRequest.getName());
		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());	
		data.setIsActive(true);		
		data.setIsDelete(false);
		super.sbType.save(data);
		logger.info("SB Type created successfully" + data);
		return "SB Type created successfully";
	}

	@Override
	public Object getSbType() throws Exception {
		Iterable<SbType> list = super.sbType.findByIsDelete(false);
		return list;
	}

	@Override
	public Object getSbTypeBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside SbType" + bankingMasterRequest);
		Optional<SbType> list = super.sbType.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (!list.isPresent()) {
			throw new NOT_FOUND("SB Type is not present");
		}
		return list;
	}

	@Override
	public Object updateSbType(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside SbType" + bankingMasterRequest);
		Optional<SbType> data = super.sbType.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("SB Type is not present");
		}
		List<SbType> tasks = new ArrayList<SbType>();
		tasks = super.sbType.findByNameAndIsDelete(false,bankingMasterRequest.getName().trim());
		if (tasks.size() > 0 && tasks.get(0).getSlno() != bankingMasterRequest.getSlno()) {
			throw new NOT_FOUND("SB Type already exists");
		}
		Date date = new Date();
		int retval = super.sbType.updateSbTypeRecord(bankingMasterRequest.getName(),
				bankingMasterRequest.getModifiedBy(), new java.sql.Date(date.getTime()),
				new java.sql.Time(date.getTime()),bankingMasterRequest.getIsActive(), bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "SB Type updated successfully";
		}
		throw new NOT_FOUND("SB Type  not present");
	}

	@Override
	public Object deleteSbType(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside SbType" + bankingMasterRequest);
		Optional<SbType> data = super.sbType.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("SB Type is not present");
		}
		int retval = super.sbType.deleteSbTypeRecord(true,bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "SB Type deleted successfully";
		}
		throw new NOT_FOUND("SB Type  not present");
	}

//	SB Accounts Parameters

	@Override
	public String createSbAccountsParameters(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside SB_Accounts Parameters" + bankingMasterRequest);

		Optional<Branch> datas = super.branch.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getBranch());
		if (bankingMasterRequest.getBranch() == null || !datas.isPresent()) {
			throw new NOT_FOUND("Branch is not present");
		}

		Optional<SbType> task = super.sbType.findBySlnoAndIsDelete(false,bankingMasterRequest.getSbType());
		if (bankingMasterRequest.getSbType() == null || !task.isPresent()) {
			throw new NOT_FOUND("SB Type is not present");
		}

		Optional<SbAccountsParameters> tasks = super.sbAccountsParameters
				.findByBranchSlnoAndSbTypeSlnoAndIsDelete(false,bankingMasterRequest.getBranch(), bankingMasterRequest.getSbType());
		if (bankingMasterRequest.getBranch() == null || bankingMasterRequest.getSbType() == null || tasks.isPresent()) {
			throw new DUPLICATE_KEY("SB_Accounts Parameters are already  exists");
		}

		Date date = new Date();
		SbAccountsParameters data = new SbAccountsParameters();
		data.setBranch(datas.get());
		data.setSbType(task.get());
		data.setSbMinBalance(bankingMasterRequest.getSbMinBalance());
		data.setSbMaxBalance(bankingMasterRequest.getSbMaxBalance());
		data.setSbRoi(bankingMasterRequest.getSbRoi());
		data.setSbMinPeriod(bankingMasterRequest.getSbMinPeriod());
		data.setServiceCharge(bankingMasterRequest.getServiceCharge());
		data.setPenalty(bankingMasterRequest.getPenalty());
		data.setSbMinBalWithCheqBookForStaff(bankingMasterRequest.getSbMinBalWithCheqBookForStaff());
		data.setSbMinBalWithoutCheqBookForStaff(bankingMasterRequest.getSbMinBalWithoutCheqBookForStaff());
		data.setSbRoiForStaff(bankingMasterRequest.getSbRoiForStaff());

		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());
		data.setIsActive(true);		
		data.setIsDelete(false);
		super.sbAccountsParameters.save(data);
		logger.info("SB_Accounts Parameters created successfully" + data);
		return "SB_Accounts Parameters created successfully";
	}

	@Override
	public Object getSbAccountsParameters() throws Exception {
		logger.info("Inside SB_Accounts Parameters" + bankingMasterRequest);
		LinkedList<Object> datalist = new LinkedList();

		Iterable<SbAccountsParameters> list = super.sbAccountsParameters.findByIsDelete(false);
		for (SbAccountsParameters t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("sbMinBalance", t.getSbMinBalance());
			result.put("sbMaxBalance", t.getSbMaxBalance());
			result.put("sbRoi", t.getSbRoi());
			result.put("sbMinPeriod", t.getSbMinPeriod());
			result.put("serviceCharge", t.getServiceCharge());
			result.put("penalty", t.getPenalty());
			result.put("sbMinBalWithCheqBookForStaff", t.getSbMinBalWithCheqBookForStaff());
			result.put("sbMinBalWithoutCheqBookForStaff", t.getSbMinBalWithoutCheqBookForStaff());
			result.put("sbRoiForStaff", t.getSbRoiForStaff());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("branchSlno", t.getBranch().getSlno());
			result.put("branchName", t.getBranch().getName());

			result.put("sbTypeSlno", t.getSbType().getSlno());
			result.put("sbTypeName", t.getSbType().getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object getSbAccountsParametersBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside SB Accounts Parameters" + bankingMasterRequest);
		LinkedList<Object> datalist = new LinkedList();

		Iterable<SbAccountsParameters> list = super.sbAccountsParameters.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		for (SbAccountsParameters t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("sbMinBalance", t.getSbMinBalance());
			result.put("sbMaxBalance", t.getSbMaxBalance());
			result.put("sbRoi", t.getSbRoi());
			result.put("sbMinPeriod", t.getSbMinPeriod());
			result.put("serviceCharge", t.getServiceCharge());
			result.put("penalty", t.getPenalty());
			result.put("sbMinBalWithCheqBookForStaff", t.getSbMinBalWithCheqBookForStaff());
			result.put("sbMinBalWithoutCheqBookForStaff", t.getSbMinBalWithoutCheqBookForStaff());
			result.put("sbRoiForStaff", t.getSbRoiForStaff());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("branchSlno", t.getBranch().getSlno());
			result.put("branchName", t.getBranch().getName());

			result.put("sbTypeSlno", t.getSbType().getSlno());
			result.put("sbTypeName", t.getSbType().getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object updateSbAccountsParameters(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside SB_Accounts Parameters" + bankingMasterRequest);

		Optional<SbAccountsParameters> data = super.sbAccountsParameters
				.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("SB_Accounts Parameters are not present");
		}
		Date date = new Date();
		int retval = super.sbAccountsParameters.updateSbAccountsParametersRecord(bankingMasterRequest.getBranch(),
				bankingMasterRequest.getSbType(), bankingMasterRequest.getSbMinBalance(),
				bankingMasterRequest.getSbMaxBalance(), bankingMasterRequest.getSbRoi(),
				bankingMasterRequest.getSbMinPeriod(), bankingMasterRequest.getServiceCharge(),
				bankingMasterRequest.getPenalty(), bankingMasterRequest.getSbMinBalWithCheqBookForStaff(),
				bankingMasterRequest.getSbMinBalWithoutCheqBookForStaff(), bankingMasterRequest.getSbRoiForStaff(),
				bankingMasterRequest.getModifiedBy(), new java.sql.Date(date.getTime()),
				new java.sql.Time(date.getTime()),bankingMasterRequest.getIsActive(), bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "SB_Accounts Parametersarameters Are updated successfully";
		}
		throw new UPDATE_FAILED("SB_Accounts Parameters Are updated Failed");
	}

	@Override
	public Object deleteSbAccountsParameters(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside SB_Accounts parameters" + bankingMasterRequest);
		Optional<SbAccountsParameters> data = super.sbAccountsParameters
				.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("SB_Accounts parameters are not present");
		}
		int retval = super.sbAccountsParameters.deleteSbAccountsParametersRecord(true,bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "SB_Accounts Parameters Are deleted Successfully";
		}
		throw new DELETE_FAILED("SB_Accounts Parameters Are deleted Failed");
	}

//	Deposit_Type

	@Override
	public String createDepositType(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Deposit_Type" + bankingMasterRequest);
		List<DepositType> val = super.depositType.findByNameAndIsDelete(false,bankingMasterRequest.getName());
		if (val.size() > 0) {
			throw new DUPLICATE_KEY("Deposit_Type already  exists");
		}
		Date date = new Date();
		DepositType data = new DepositType();
		data.setName(bankingMasterRequest.getName());
		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());
		data.setIsActive(bankingMasterRequest.getIsActive());
		super.depositType.save(data);
		logger.info("Deposit_Type created successfully" + data);
		return "Deposit_Type created successfully";
	}

	@Override
	public Object getDepositType() throws Exception {
		Iterable<DepositType> list = super.depositType.findByIsDelete(false);
		return list;
	}

	@Override
	public Object getDepositTypeBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside SbType" + bankingMasterRequest);
		Optional<DepositType> list = super.depositType.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (!list.isPresent()) {
			throw new NOT_FOUND("Deposit_Type is not present");
		}
		return list;
	}

	@Override
	public Object updateDepositType(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Deposit_Type" + bankingMasterRequest);
		Optional<DepositType> data = super.depositType.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Deposit_Type is not present");
		}
		List<DepositType> tasks = new ArrayList<DepositType>();
		tasks = super.depositType.findByNameAndIsDelete(false,bankingMasterRequest.getName().trim());
		if (tasks.size() > 0 && tasks.get(0).getSlno() != bankingMasterRequest.getSlno()) {
			throw new NOT_FOUND("Deposit_Type already exists");
		}
		Date date = new Date();
		int retval = super.depositType.updateSbTypeRecord(bankingMasterRequest.getName(),
				bankingMasterRequest.getModifiedBy(), new java.sql.Date(date.getTime()),
				new java.sql.Time(date.getTime()), bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "Deposit_Type updated successfully";
		}
		throw new NOT_FOUND("Deposit_Type  not present");
	}

	@Override
	public Object deleteDepositType(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside SbType" + bankingMasterRequest);
		Optional<DepositType> data = super.depositType.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Deposit_Type is not present");
		}
		int retval = super.depositType.deleteDepositTypeRecord(bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "Deposit_Type deleted successfully";
		}
		throw new DELETE_FAILED("Deposit_Type  deleted failed ");
	}

//	Compounding_period

	@Override
	public String createCompoundingPeriod(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Compounding_Period" + bankingMasterRequest);
		List<CompoundingPeriod> val = super.compoundingPeriod.findByNameAndIsDelete(false,bankingMasterRequest.getName());
		if (val.size() > 0) {
			throw new DUPLICATE_KEY("compoundingPeriod already  exists");
		}
		Date date = new Date();
		CompoundingPeriod data = new CompoundingPeriod();
		data.setName(bankingMasterRequest.getName());
		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());
		data.setIsActive(bankingMasterRequest.getIsActive());
		super.compoundingPeriod.save(data);
		logger.info("Compounding_period created successfully" + data);
		return "Compounding_Period created successfully";
	}

	@Override
	public Object getCompoundingPeriod() throws Exception {
		Iterable<CompoundingPeriod> list = super.compoundingPeriod.findByIsDelete(false);
		return list;
	}

	@Override
	public Object getCompoundingPeriodBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Relationship" + bankingMasterRequest);
		Optional<CompoundingPeriod> list = super.compoundingPeriod.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (!list.isPresent()) {
			throw new NOT_FOUND("Compounding Period is not present");
		}
		return list;
	}

	@Override
	public Object updateCompoundingPeriod(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Relationship" + bankingMasterRequest);
		Optional<CompoundingPeriod> data = super.compoundingPeriod.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Compounding_period is not present");
		}
		List<CompoundingPeriod> tasks = new ArrayList<CompoundingPeriod>();
		tasks = super.compoundingPeriod.findByNameAndIsDelete(false,bankingMasterRequest.getName().trim());
		if (tasks.size() > 0 && tasks.get(0).getSlno() != bankingMasterRequest.getSlno()) {
			throw new NOT_FOUND("Compounding_period already exists");
		}
		Date date = new Date();
		int retval = super.compoundingPeriod.updateCompoundingPeriodRecord(bankingMasterRequest.getName(),
				bankingMasterRequest.getModifiedBy(), new java.sql.Date(date.getTime()),
				new java.sql.Time(date.getTime()), bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "Compounding_period updated successfully";
		}
		throw new NOT_FOUND("Compounding_period  not present");
	}

	@Override
	public Object deleteCompoundingPeriod(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside compoundingPeriod" + bankingMasterRequest);
		Optional<CompoundingPeriod> data = super.compoundingPeriod.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Compounding_period is not present");
		}
		int retval = super.compoundingPeriod.deleteCompoundingPeriodRecord(bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "Compounding_period deleted successfully";
		}
		throw new NOT_FOUND("Compounding_period not present");
	}

//	Holiday_list

	@Override
	public String createHolidayList(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Holiday_list" + bankingMasterRequest);

		Optional<Branch> datas = super.branch.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getBranch());
		if (bankingMasterRequest.getBranch() == null || !datas.isPresent()) {
			throw new NOT_FOUND("Branch is not present");
		}
		Optional<FinancialYear> task = super.financialYear.findBySlnoAndIsDelete(false,bankingMasterRequest.getFinancialYear());
		if (bankingMasterRequest.getFinancialYear() == null || !task.isPresent()) {
			throw new NOT_FOUND("Financial_Year is not present");
		}
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date simpaleDate = format.parse(bankingMasterRequest.getHolidayDate());

		List<HolidayList> val = super.holidayList.findByDate(simpaleDate);
		if (val.size() > 0) {
			throw new DUPLICATE_KEY("Holiday already  exists");
		}

		Date date = new Date();
		HolidayList data = new HolidayList();
		data.setBranch(datas.get());
		data.setFinancialYear(task.get());
		data.setHolidayDate(simpaleDate);

		data.setHolidayName(bankingMasterRequest.getHolidayName());

		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());
        data.setIsActive(bankingMasterRequest.getIsActive());
		super.holidayList.save(data);
		logger.info("Holiday_list created successfully" + data);
		return "Holiday_list created successfully";
	}

	@Override
	public Object getHolidayList() throws Exception {
		logger.info("Inside Holiday_list Parameters" + bankingMasterRequest);
		LinkedList<Object> datalist = new LinkedList();

		Iterable<HolidayList> list = super.holidayList.findByIsDelete(false);
		for (HolidayList t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());

			result.put("holidayDate", t.getHolidayDate());
			result.put("holidayName", t.getHolidayName());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("branchSlno", t.getBranch().getSlno());
			result.put("branchName", t.getBranch().getName());

			result.put("financialYearSlno", t.getFinancialYear().getSlno());
			result.put("financialYear", t.getFinancialYear().getFromYear() + "-" + t.getFinancialYear().getToYear());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object getHolidayListBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Holiday_list" + bankingMasterRequest);
		LinkedList<Object> datalist = new LinkedList();

		Iterable<HolidayList> list = super.holidayList.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		for (HolidayList t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("holidayDate", t.getHolidayDate());
			result.put("holidayName", t.getHolidayName());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("branchSlno", t.getBranch().getSlno());
			result.put("branchName", t.getBranch().getName());

			result.put("financialYearSlno", t.getFinancialYear().getSlno());
			result.put("financialYear", t.getFinancialYear().getFromYear() + "-" + t.getFinancialYear().getToYear());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object updateHolidayList(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Holiday_list" + bankingMasterRequest);

		Optional<HolidayList> data = super.holidayList.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Holiday_list not present");
		}
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date simpaleDate = format.parse(bankingMasterRequest.getHolidayDate());
		Date date = new Date();
		int retval = super.holidayList.updateHolidayListRecord(bankingMasterRequest.getBranch(),
				bankingMasterRequest.getFinancialYear(), simpaleDate, bankingMasterRequest.getHolidayName(),
				bankingMasterRequest.getModifiedBy(), new java.sql.Date(date.getTime()),
				new java.sql.Time(date.getTime()), bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "Holiday_list updated successfully";
		}
		throw new UPDATE_FAILED("Holiday_list updated Failed");
	}

	@Override
	public Object deleteHolidayList(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Holiday_list" + bankingMasterRequest);
		Optional<HolidayList> data = super.holidayList.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Holiday_list is not present");
		}
		int retval = super.holidayList.deleteHolidayList(bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "Holiday_list deleted successfully";
		}
		throw new NOT_FOUND("Holiday_list not present");
	}
// Late_fee_parameter

	@Override
	public String createLateFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Late_fee_parameter" + bankingMasterRequest);

		Optional<CompoundingPeriod> datas = super.compoundingPeriod
				.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getCompoundingPeriod());
		if (bankingMasterRequest.getCompoundingPeriod() == null || !datas.isPresent()) {
			throw new NOT_FOUND("compoundingPeriod is not present");
		}
		List<LateFeeParameter> val = super.lateFeeParameter
				.findByCompoundingPeriodSlnoAndIsDelete(false,bankingMasterRequest.getCompoundingPeriod());
		if (val.size() > 0) {
			throw new DUPLICATE_KEY("Late_fee_parameter  already exists");
		}
		Date date = new Date();
		LateFeeParameter data = new LateFeeParameter();
		data.setCompoundingPeriod(datas.get());
		data.setLateFees(bankingMasterRequest.getLateFees());
		data.setGracePeriod(bankingMasterRequest.getGracePeriod());

		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());
		data.setIsActive(bankingMasterRequest.getIsActive());
		super.lateFeeParameter.save(data);
		logger.info("Late_fee_parameter created successfully" + data);
		return "Late_fee_parameter created successfully";
	}

	@Override
	public Object getLateFeeParameter() throws Exception {
		LinkedList<Object> datalist = new LinkedList();

		Iterable<LateFeeParameter> list = super.lateFeeParameter.findByIsDelete(false);
		for (LateFeeParameter t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("GracePeriod", t.getGracePeriod());
			result.put("LateFees", t.getLateFees());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("memberTypeSlno", t.getCompoundingPeriod().getSlno());
			result.put("memberTypeName", t.getCompoundingPeriod().getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object getlateFeeParameterBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Late_fee_parameter" + bankingMasterRequest);
		LinkedList<Object> datalist = new LinkedList();

		Iterable<LateFeeParameter> list = super.lateFeeParameter.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		for (LateFeeParameter t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("memberTypeSlno", t.getCompoundingPeriod().getSlno());
			result.put("memberTypeName", t.getCompoundingPeriod().getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object updateLateFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Late_fee_parameter" + bankingMasterRequest);

		Optional<LateFeeParameter> data = super.lateFeeParameter.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getCompoundingPeriod() == null || !data.isPresent()) {
			throw new NOT_FOUND("Late_fee_parameter not present");
		}
		Date date = new Date();
		int retval = super.lateFeeParameter.updateLateFeeParameterRecord(bankingMasterRequest.getCompoundingPeriod(),
				bankingMasterRequest.getGracePeriod(), bankingMasterRequest.getLateFees(),
				bankingMasterRequest.getModifiedBy(), new java.sql.Date(date.getTime()),
				new java.sql.Time(date.getTime()), bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "Late_fee_parameter updated successfully";
		}
		throw new UPDATE_FAILED("Late_fee_parameter updated Failed");
	}

	@Override
	public Object deleteLateFeeParameter(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Late_fee_paramete" + bankingMasterRequest);
		Optional<LateFeeParameter> data = super.lateFeeParameter.findBySlnoValueAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Late_fee_paramete is not present");
		}
		int retval = super.lateFeeParameter.deleteLateFeeParameter(bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "Late_fee_paramete deleted successfully";
		}
		throw new NOT_FOUND("Late_fee_paramete not present");
	}

//	charges 

	@Override
	public String createCharges(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Charges" + bankingMasterRequest);
		List<Charges> val = super.charges.findByChargesAndIsDelete(false,bankingMasterRequest.getCharges());
		if (val.size() > 0) {
			throw new DUPLICATE_KEY("Charges_type already  exists");
		}
		Date date = new Date();
		Charges data = new Charges();
		data.setCharges(bankingMasterRequest.getCharges());
		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(bankingMasterRequest.getCreatedBy());
		data.setIsActive(bankingMasterRequest.getIsActive());
		super.charges.save(data);
		logger.info("Charges_Type created successfully" + data);
		return "Charges_type created successfully";
	}

	@Override
	public Object getCharges() throws Exception {
		Iterable<Charges> list = super.charges.findByIsDelete(false);
		return list;
	}
	
	@Override
	public Object getChargesBySlno(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Charges_type" + bankingMasterRequest);
		Optional<Charges> list = super.charges.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (!list.isPresent()) {
			throw new NOT_FOUND("Charges_type is not present");
		}
		return list;
	}
	
	@Override
	public Object updateCharges(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Charges" + bankingMasterRequest);
		Optional<Charges> data = super.charges.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Charges_type is not present");
		}
		List<Charges> tasks = new ArrayList<Charges>();
		tasks = super.charges.findByChargesAndIsDelete(false,bankingMasterRequest.getCharges().trim());
		if (tasks.size() > 0 && tasks.get(0).getSlno() != bankingMasterRequest.getSlno()) {
			throw new NOT_FOUND("Charges_type already exists");
		}
		Date date = new Date();
		int retval = super.charges.updateChargesRecord(bankingMasterRequest.getCharges(),
				 bankingMasterRequest.getModifiedBy(),
				new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()), bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "Charges_type updated successfully";
		}
		throw new UPDATE_FAILED("Charges_type  updated Failed");
	}

	@Override
	public Object deleteCharges(BankingMasterRequest bankingMasterRequest) throws Exception {
		logger.info("Inside Charges_type" + bankingMasterRequest);
		Optional<Charges> data = super.charges.findBySlnoAndIsDelete(false,bankingMasterRequest.getSlno());
		if (bankingMasterRequest.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Charges_type is not present");
		}
		int retval = super.charges.deleteChargesRecord(bankingMasterRequest.getSlno());
		if (retval == 1) {
			return "Charges_type deleted successfully";
		}
		throw new DELETE_FAILED("Charges_type  deleted failed");
	}
	
	}