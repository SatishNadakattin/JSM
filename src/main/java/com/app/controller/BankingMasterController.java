package com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.GenericRes;
import com.app.exception.HttpResponseUtils;
import com.app.request.BankingMasterRequest;
import com.app.service.BankingMasterService;

@RequestMapping("/master/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
public class BankingMasterController {

	private static final Logger logger = LoggerFactory.getLogger(BankingMasterController.class);

	@Autowired
	private BankingMasterService bankingMasterService;

	@Autowired
	private HttpResponseUtils HttpResponseUtils;

//Relationship Features

	@PostMapping(value = "/relationship/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> saveRelationship(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.saveRelationship(bankingMasterRequest));
	}

	@PostMapping(value = "/relationship/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getRelationship()
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getRelationship());
	}

	@PostMapping(value = "/relationship/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getRelationshipBySlno(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getRelationshipBySlno(bankingMasterRequest));
	}

	@PostMapping(value = "/relationship/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateRelationship(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.updateRelationship(bankingMasterRequest));
	}

	@PostMapping(value = "/relationship/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteRelationship(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.deleteRelationship(bankingMasterRequest));
	}

//	memberType 

	@PostMapping(value = "/memberType/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createMemberType(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.createMemberType(bankingMasterRequest));
	}

	@PostMapping(value = "/memberType/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getMemberType()
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getMemberType());
	}

	@PostMapping(value = "/memberType/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getMemberTypeBySlno(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getMemberTypeBySlno(bankingMasterRequest));
	}

	@PostMapping(value = "/memberType/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateMemberType(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.updateMemberType(bankingMasterRequest));
	}

	@PostMapping(value = "/memberType/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteMemberType(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.deleteMemberType(bankingMasterRequest));
	}
//	share_parameter

	@PostMapping(value = "/shareParameter/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createShareParameter(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.createShareParameter(bankingMasterRequest));
	}

	@PostMapping(value = "/shareParameter/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getShareParameter()
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getShareParameter());
	}

	@PostMapping(value = "/shareParameter/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getShareParameterBySlno(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getShareParameterBySlno(bankingMasterRequest));
	}

	@PostMapping(value = "/shareParameter/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateShareParameter(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.updateShareParameter(bankingMasterRequest));
	}

	@PostMapping(value = "/shareParameter/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteShareParameter(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.deleteShareParameter(bankingMasterRequest));
	}

//	Fee Parameter

	@PostMapping(value = "/feeParameter/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createfeeParameter(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.createFeeParameter(bankingMasterRequest));
	}

	@PostMapping(value = "/feeParameter/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getFeeParameter()
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getFeeParameter());
	}

	@PostMapping(value = "/feeParameter/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getFeeParameterBySlno(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getFeeParameterBySlno(bankingMasterRequest));
	}

	@PostMapping(value = "/feeParameter/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateFeeParameter(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.updateFeeParameter(bankingMasterRequest));
	}

	@PostMapping(value = "/feeParameter/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteFeeParameter(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.deleteFeeParameter(bankingMasterRequest));
	}

//	SB_Type

	@PostMapping(value = "/sbType/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createSbType(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.createSbType(bankingMasterRequest));
	}

	@PostMapping(value = "/sbType/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getSbType()
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getSbType());
	}

	@PostMapping(value = "/sbType/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getSbTypeBySlno(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getSbTypeBySlno(bankingMasterRequest));
	}

	@PostMapping(value = "/sbType/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateSbType(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.updateSbType(bankingMasterRequest));
	}

	@PostMapping(value = "/sbType/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteSbType(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.deleteSbType(bankingMasterRequest));
	}

//	SB Accounts Parameters

	@PostMapping(value = "/sbAccountsParameters/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createSbAccountsParameters(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.createSbAccountsParameters(bankingMasterRequest));
	}

	@PostMapping(value = "/sbAccountsParameters/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getSbAccountsParameters()
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getSbAccountsParameters());
	}

	@PostMapping(value = "/sbAccountsParameters/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getSbAccountsParametersBySlno(
			@RequestBody BankingMasterRequest bankingMasterRequest) throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getSbAccountsParametersBySlno(bankingMasterRequest));
	}

	@PostMapping(value = "/sbAccountsParameters/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateSbAccountsParameters(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.updateSbAccountsParameters(bankingMasterRequest));
	}

	@PostMapping(value = "/sbAccountsParameters/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteSbAccountsParameters(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.deleteSbAccountsParameters(bankingMasterRequest));
	}

//	Deposit Type

	@PostMapping(value = "/depositType/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createDepositType(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.createDepositType(bankingMasterRequest));
	}

	@PostMapping(value = "/depositType/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getDepositType()
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getDepositType());
	}

	@PostMapping(value = "/depositType/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getDepositTypeBySlno(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getDepositTypeBySlno(bankingMasterRequest));
	}

	@PostMapping(value = "/depositType/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateDepositType(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.updateDepositType(bankingMasterRequest));
	}

	@PostMapping(value = "/depositType/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteDepositType(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.deleteDepositType(bankingMasterRequest));
	}
//	Compounding_Period

	@PostMapping(value = "/compoundingPeriod/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createCompoundingPeriod(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.createCompoundingPeriod(bankingMasterRequest));
	}

	@PostMapping(value = "/compoundingPeriod/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getCompoundingPeriod()
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getCompoundingPeriod());
	}

	@PostMapping(value = "/compoundingPeriod/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getCompoundingPeriodBySlno(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getCompoundingPeriodBySlno(bankingMasterRequest));
	}

	@PostMapping(value = "/compoundingPeriod/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateCompoundingPeriod(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.updateCompoundingPeriod(bankingMasterRequest));
	}

	@PostMapping(value = "/compoundingPeriod/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteCompoundingPeriod(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.deleteCompoundingPeriod(bankingMasterRequest));
	}

//	Holiday_list

	@PostMapping(value = "/holidayList/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createHolidayList(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.createHolidayList(bankingMasterRequest));
	}

	@PostMapping(value = "/holidayList/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getHolidayList()
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getHolidayList());
	}

	@PostMapping(value = "/holidayList/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getHolidayListBySlno(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getHolidayListBySlno(bankingMasterRequest));
	}

	@PostMapping(value = "/holidayList/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateHolidayList(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.updateHolidayList(bankingMasterRequest));
	}

	@PostMapping(value = "/holidayList/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteHolidayList(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.deleteHolidayList(bankingMasterRequest));
	}

//	Late_fee_parameter 

	@PostMapping(value = "/lateFeeParameter/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createLateFeeParameter(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.createLateFeeParameter(bankingMasterRequest));
	}

	@PostMapping(value = "/lateFeeParameter/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getLateFeeParameter()
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getLateFeeParameter());
	}

	@PostMapping(value = "/lateFeeParameter/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getlateFeeParameterBySlno(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getlateFeeParameterBySlno(bankingMasterRequest));
	}

	@PostMapping(value = "/lateFeeParameter/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateLateFeeParameter(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.updateLateFeeParameter(bankingMasterRequest));
	}

	@PostMapping(value = "/lateFeeParameter/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteLateFeeParameter(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.deleteLateFeeParameter(bankingMasterRequest));
	}

//	charges in service Deduction

	@PostMapping(value = "/charges/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createCharges(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.createCharges(bankingMasterRequest));
	}
	
	@PostMapping(value = "/charges/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getCharges()
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(bankingMasterService.getCharges());
	}
	
	@PostMapping(value = "/charges/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getChargesBySlno(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.getChargesBySlno(bankingMasterRequest));
	}
	
	@PostMapping(value = "/charges/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateCharges(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.updateCharges(bankingMasterRequest));
	}
	
	@PostMapping(value = "/charges/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteCharges(@RequestBody BankingMasterRequest bankingMasterRequest)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(bankingMasterService.deleteCharges(bankingMasterRequest));
	}

}