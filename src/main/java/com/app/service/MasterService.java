package com.app.service;

import java.util.Map;

import javax.validation.Valid;

import com.app.request.BankingMasterRequest;
import com.app.request.CommonRequest;
import com.app.request.UserRequest;

public interface MasterService {

	Map<String, String> createState(CommonRequest request);

	Map<String, Object> getState();

	Map<String, Object> updateState(CommonRequest request);

	Map<String, Object> deleteState(CommonRequest request);

	Map<String, Object> getStateBySlno(CommonRequest request);

	Map<String, String> createdistrict( CommonRequest request);

	Map<String, Object> getdistrict();

	Map<String, Object> getdistrictBySlno(CommonRequest request);

	Map<String, Object> deletedistrict(CommonRequest request);

	Map<String, Object> updatedistrict(CommonRequest request);

	Map<String, String> createnews( CommonRequest request);

	Map<String, String> createusers(@Valid UserRequest request);

	Map<String, Object> getnews();

	Map<String, Object> getnewsBySlno(CommonRequest request);

	Map<String, Object> deletenews(CommonRequest request);

	Map<String, Object> updatenews(CommonRequest request);

	Map<String, Object> createFinancialYear(CommonRequest request);

	Map<String, Object> getFinancialYear();

	Map<String, Object> getFinancialYearBySlno(CommonRequest request);

	Map<String, Object> updateFinancialYear(CommonRequest request);

	Map<String, Object> deleteFinancialYear(CommonRequest request);

//	branch
	
	public Object createBranch(CommonRequest request) throws Exception;

	public Object getBranch() throws Exception;

	public Object getBranchBySlno(CommonRequest request) throws Exception;

	public Object updateBranch(CommonRequest request) throws Exception;

	public Object deleteBranch(CommonRequest request) throws Exception;
	
	
	Map<String, Object> changePassword(UserRequest request);

	Map<String, Object> createIpAddress(CommonRequest request);

	Map<String, Object> getIpAddress();

	Map<String, Object> getIpAddressBySlno(CommonRequest request);

	Map<String, Object> updateIpAddress(CommonRequest request);

	Map<String, Object> deleteIpAddress(CommonRequest request);

	Map<String, Object> IpAddressbasedOnStatus(CommonRequest request);

	Map<String, Object> createServiceCenter(CommonRequest request);

	Map<String, Object> getServiceCenter();

	Map<String, Object> getServiceCenterBySlno(CommonRequest request);

	Map<String, Object> updateServiceCenter(CommonRequest request);

	Map<String, Object> deleteServiceCenter(CommonRequest request);

	Map<String, Object> createserviceCenterUser(CommonRequest request);

	Map<String, Object> getServiceCenterUser();

	Map<String, Object> getServiceCenterUserBySlno(CommonRequest request);

	Map<String, Object> updateServiceCenterUser(CommonRequest request);

	Map<String, Object> deleteServiceCenterUser(CommonRequest request);

	Map<String, Object> enableORDisableOnBranch(CommonRequest request);

	Map<String, String> createCountry( CommonRequest request);

	Map<String, Object> getCountry(CommonRequest request);

	Map<String, Object> getCountryBySlno(CommonRequest request);

	Map<String, Object> updateCountry(CommonRequest request);

	Map<String, Object> deleteCountry(CommonRequest request);
	
//	taluk

	public Object createTaluk(CommonRequest request) throws Exception;
//	public String createBod(CommonRequest request) throws Exception;

	public Object getTaluk(CommonRequest request) throws Exception;

	public Object getTalukBySlno(CommonRequest request) throws Exception;

	public Object updateTaluk(CommonRequest request) throws Exception;

	public Object deleteTaluk(CommonRequest request) throws Exception;

}
