package com.app.controller;

import java.util.Map;

import javax.validation.Valid;

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
import com.app.request.CommonRequest;
import com.app.request.UserRequest;
import com.app.service.MasterService;


@RequestMapping("/master/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MasterController {

	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);
	@Autowired
	private MasterService masterService;
	
	@Autowired
	private HttpResponseUtils HttpResponseUtils;

	@PostMapping(value = "/country/create", produces = "application/json")
	public Map<String, String> createCountry(@RequestBody CommonRequest request) {
		return masterService.createCountry(request);
	}

	@PostMapping(value = "/country/get")
	public Map<String, Object> getCountry(@RequestBody CommonRequest request) {
		return masterService.getCountry(request);
	}

	@PostMapping(value = "/country/getBySlno")
	public Map<String, Object> getCountryBySlno(@RequestBody CommonRequest request) {
		return masterService.getCountryBySlno(request);
	}

	@PostMapping(value = "/country/update")
	public Map<String, Object> updateCountry(@RequestBody CommonRequest request) {
		return masterService.updateCountry(request);
	}

	@PostMapping(value = "/country/delete")
	public Map<String, Object> deleteCountry(@RequestBody CommonRequest request) {
		return masterService.deleteCountry(request);
	}

	@PostMapping(value = "/state/create")
	public Map<String, String> createState(@Valid @RequestBody CommonRequest request) {
		return masterService.createState(request);
	}

	@PostMapping(value = "/state/get")
	public Map<String, Object> getState() {
		return masterService.getState();
	}

	@PostMapping(value = "/state/getBySlno")
	public Map<String, Object> getStateBySlno(@RequestBody CommonRequest request) {
		return masterService.getStateBySlno(request);
	}

	@PostMapping(value = "/state/update")
	public Map<String, Object> updateState(@RequestBody CommonRequest request) {
		return masterService.updateState(request);
	}

	@PostMapping(value = "/state/delete")
	public Map<String, Object> deleteState(@RequestBody CommonRequest request) {
		return masterService.deleteState(request);
	}

	// District Api's
	@PostMapping(value = "/district/create")
	public Map<String, String> createdistrict(@Valid @RequestBody CommonRequest request) {
		return masterService.createdistrict(request);
	}

	@PostMapping(value = "/district/get")
	public Map<String, Object> getdistrict(@RequestBody CommonRequest request) {
		return masterService.getdistrict();
	}

	@PostMapping(value = "/district/getBySlno")
	public Map<String, Object> getdistrictBySlno(@RequestBody CommonRequest request) {
		return masterService.getdistrictBySlno(request);
	}

	@PostMapping(value = "/district/delete")
	public Map<String, Object> deletedistrict(@RequestBody CommonRequest request) {
		return masterService.deletedistrict(request);
	}

	@PostMapping(value = "/district/update")
	public Map<String, Object> updatedistrict(@RequestBody CommonRequest request) {
		return masterService.updatedistrict(request);
	}

	@PostMapping(value = "/users/create")
	public Map<String, String> createusers(@Valid @RequestBody UserRequest request) {
		return masterService.createusers(request);
	}

	// News APis
	@PostMapping(value = "/news/create")
	public Map<String, String> createnews(@Valid @RequestBody CommonRequest request) {
		return masterService.createnews(request);
	}

	@PostMapping(value = "/news/get")
	public Map<String, Object> getnews(@RequestBody CommonRequest request) {
		return masterService.getnews();
	}

	@PostMapping(value = "/news/getBySlno")
	public Map<String, Object> getnewsBySlno(@RequestBody CommonRequest request) {
		return masterService.getnewsBySlno(request);
	}

	@PostMapping(value = "/news/delete")
	public Map<String, Object> deletenews(@RequestBody CommonRequest request) {
		return masterService.deletenews(request);
	}

	@PostMapping(value = "/news/update")
	public Map<String, Object> updatenews(@RequestBody CommonRequest request) {
		return masterService.updatenews(request);
	}

	@PostMapping(value = "/financialYear/create")
	public Map<String, Object> createFinancialYear(@RequestBody CommonRequest request) {
		return masterService.createFinancialYear(request);
	}

	@PostMapping(value = "/financialYear/get")
	public Map<String, Object> getFinancialYear(@RequestBody CommonRequest request) {
		return masterService.getFinancialYear();
	}

	@PostMapping(value = "/financialYear/getBySlno")
	public Map<String, Object> getFinancialYearBySlno(@RequestBody CommonRequest request) {
		return masterService.getFinancialYearBySlno(request);
	}

	@PostMapping(value = "/financialYear/update")
	public Map<String, Object> updateFinancialYear(@RequestBody CommonRequest request) {
		return masterService.updateFinancialYear(request);
	}

	@PostMapping(value = "/financialYear/delete")
	public Map<String, Object> deleteFinancialYear(@RequestBody CommonRequest request) {
		return masterService.deleteFinancialYear(request);
	}

	
//	branch
	
	@PostMapping(value = "/branch/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createBranch(@RequestBody CommonRequest request)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(masterService.createBranch(request));
	}
	
	@PostMapping(value = "/branch/get", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getBranch()
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(masterService.getBranch());
	}
	
	@PostMapping(value = "/branch/getBySlno", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getBranchBySlno(@RequestBody CommonRequest request)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(masterService.getBranchBySlno(request));
	}
	
	@PostMapping(value = "/branch/update", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> updateBranch(@RequestBody CommonRequest request)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(masterService.updateBranch(request));
	}
	
	@PostMapping(value = "/branch/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteBranch(@RequestBody CommonRequest request)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(masterService.deleteBranch(request));
	}
		
	
	
	
	
	
	

	@PostMapping(value = "/users/changePassword")
	public Map<String, Object> changePassword(@RequestBody UserRequest request) {
		return masterService.changePassword(request);
	}

	@PostMapping(value = "/ipAddress/create")
	public Map<String, Object> createIpAddress(@RequestBody CommonRequest request) {
		return masterService.createIpAddress(request);
	}

	@PostMapping(value = "/ipAddress/get")
	public Map<String, Object> getIpAddress(@RequestBody CommonRequest request) {
		return masterService.getIpAddress();
	}

	@PostMapping(value = "/ipAddress/getBySlno")
	public Map<String, Object> getIpAddressBySlno(@RequestBody CommonRequest request) {
		return masterService.getIpAddressBySlno(request);
	}

	@PostMapping(value = "/ipAddress/update")
	public Map<String, Object> updateIpAddress(@RequestBody CommonRequest request) {
		return masterService.updateIpAddress(request);
	}

	@PostMapping(value = "/ipAddress/delete")
	public Map<String, Object> deleteIpAddress(@RequestBody CommonRequest request) {
		return masterService.deleteIpAddress(request);
	}

	@PostMapping(value = "/ipAddress/basedOnStatus")
	public Map<String, Object> IpAddressbasedOnStatus(@RequestBody CommonRequest request) {
		return masterService.IpAddressbasedOnStatus(request);
	}

	@PostMapping(value = "/serviceCenter/create")
	public Map<String, Object> createServiceCenter(@RequestBody CommonRequest request) {
		return masterService.createServiceCenter(request);
	}

	@PostMapping(value = "/serviceCenter/get")
	public Map<String, Object> getserviceCenter(@RequestBody CommonRequest request) {
		return masterService.getServiceCenter();
	}

	@PostMapping(value = "/serviceCenter/getBySlno")
	public Map<String, Object> getserviceCenterBySlno(@RequestBody CommonRequest request) {
		return masterService.getServiceCenterBySlno(request);
	}

	@PostMapping(value = "/serviceCenter/update")
	public Map<String, Object> updateserviceCenter(@RequestBody CommonRequest request) {
		return masterService.updateServiceCenter(request);
	}

	@PostMapping(value = "/serviceCenter/delete")
	public Map<String, Object> deleteserviceCenter(@RequestBody CommonRequest request) {
		return masterService.deleteServiceCenter(request);
	}

	@PostMapping(value = "/serviceCenterUser/create")
	public Map<String, Object> createserviceCenterUser(@RequestBody CommonRequest request) {
		return masterService.createserviceCenterUser(request);
	}

	@PostMapping(value = "/serviceCenterUser/get")
	public Map<String, Object> getServiceCenterUser(@RequestBody CommonRequest request) {
		return masterService.getServiceCenterUser();
	}

	@PostMapping(value = "/serviceCenterUser/getBySlno")
	public Map<String, Object> getServiceCenterUserBySlno(@RequestBody CommonRequest request) {
		return masterService.getServiceCenterUserBySlno(request);
	}

	@PostMapping(value = "/serviceCenterUser/update")
	public Map<String, Object> updateServiceCenterUser(@RequestBody CommonRequest request) {
		return masterService.updateServiceCenterUser(request);
	}

	@PostMapping(value = "/serviceCenterUser/delete")
	public Map<String, Object> deleteServiceCenterUser(@RequestBody CommonRequest request) {
		return masterService.deleteServiceCenterUser(request);
	}

	@PostMapping(value = "/ipAddress/enableORDisableOnBranch")
	public Map<String, Object> enableORDisableOnBranch(@RequestBody CommonRequest request) {
		return masterService.enableORDisableOnBranch(request);
	}

	
	// District Api's
	
	@PostMapping(value = "/taluk/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> createTaluk(@RequestBody CommonRequest request)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(masterService.createTaluk(request));
	}
	//@CrossOrigin(origins = "http://192.168.0.120:3000")
	@PostMapping(value = "/taluk/get")
	public ResponseEntity<GenericRes> getTaluk(@RequestBody CommonRequest request)
			throws Exception {
		return HttpResponseUtils.prepareSuccessResponse(masterService.getTaluk(request));
	}
	
	@PostMapping(value = "/taluk/getBySlno", produces = "application/json")
	public ResponseEntity<GenericRes> getTalukBySlno(@RequestBody CommonRequest request)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(masterService.getTalukBySlno(request));
	}
	
	@PostMapping(value = "/taluk/update", produces = "application/json")
	public ResponseEntity<GenericRes> updateTaluk(@RequestBody CommonRequest request)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(masterService.updateTaluk(request));
	}
	
	@PostMapping(value = "/taluk/delete", produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> deleteTaluk(@RequestBody CommonRequest request)
			throws Exception {
		return HttpResponseUtils
				.prepareSuccessResponse(masterService.deleteTaluk(request));
	}
}

//@PostMapping(value = "/createBod")
//@ResponseBody
//public ResponseEntity<GenericRes> createBod(
//		@RequestBody CommonRequest request) throws Exception {
//	return HttpResponseUtils.prepareSuccessResponse(masterService.createBod(request));
//}

/*
 * @PostMapping(value = "/state/create") public ResponseEntity<Object>
 * createState(@RequestBody State state) { masterService.createState(state);
 * return new ResponseEntity<>("State is created successfully",
 * HttpStatus.CREATED); }
 */