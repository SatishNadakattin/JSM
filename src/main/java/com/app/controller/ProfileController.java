package com.app.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.GenericRes;
import com.app.exception.HttpResponseUtils;
import com.app.request.RolesAndPrivillageRequest;
import com.app.service.ProfileService;

@RestController

@RequestMapping("/profile/")
public class ProfileController {
	
	
	 private static final Logger logger = LoggerFactory.getLogger(MasterController.class);
	 
	     @Autowired
		private ProfileService rolesAndPrivileService;
	     
	     @Autowired
		private HttpResponseUtils   httpResponseUtils;
		
		@PostMapping(value = "/modules/create" )
		public Map<String, String> createModules(  @RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.createModules(request);			
		}
		@PostMapping(value = "/modules/get")
		public Map<String, Object> getModules(@RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.getModules(request);			
		}
		@PostMapping(value = "/modules/getBySlno")
		public Map<String, Object> getModulesBySlno(@RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.getModulesBySlno(request);			
		}
		@PostMapping(value = "/modules/update")
		public Map<String, Object> updateModules(@RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.updateModules(request);			
		}
		@PostMapping(value = "/modules/delete")
		public Map<String, Object> deleteeModules(@RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.deleteModules(request);			
		}
		
		@PostMapping(value = "/features/create" )
		public Map<String, String> createFeatures(  @RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.createFeatures(request);			
		}

		@PostMapping(value = "/features/get" )
		public Map<String, Object> getFeatures(  @RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.getFeatures(request);			
		}
		
		@PostMapping(value = "/features/getBySlno" )
		public Map<String, Object> getFeaturesBySlno(  @RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.getFeaturesBySlno(request);			
		}
		
		@PostMapping(value = "/features/update" )
		public Map<String, Object>updateFeatures(  @RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.updateFeatures(request);			
		}
		@PostMapping(value = "/features/delete" )
		public Map<String, Object>deleteFeatures(  @RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.deleteFeatures(request);			
		}
		
		@PostMapping(value = "/roles/create" )
		@ResponseBody
		public  ResponseEntity<GenericRes>  createRoles(  @RequestBody RolesAndPrivillageRequest request)  throws Exception{
				return httpResponseUtils.prepareSuccessResponse(rolesAndPrivileService.createRoles(request));			
		}
		
	
		
		
		
		@PostMapping(value = "/roles/get" )
		@ResponseBody
		public ResponseEntity<GenericRes> getRoles(  @RequestBody RolesAndPrivillageRequest request)  throws Exception{
			return httpResponseUtils.prepareSuccessResponse(rolesAndPrivileService.getRoles(request));			
		}
		
		@PostMapping(value = "/roles/getBySlno" )
		public Map<String, Object> getRolesBySlno(  @RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.getRolesBySlno(request);			
		}
		
		@PostMapping(value = "/roles/update" )
		public Map<String, Object>updateRoles(  @RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.updateRoles(request);			
		}
		@PostMapping(value = "/roles/delete" )
		public Map<String, Object>deleteRoles(  @RequestBody RolesAndPrivillageRequest request) {
				return rolesAndPrivileService.deleteRoles(request);			
		}
		
		
		@PostMapping(value = "/privilege/create" )
		@ResponseBody
		public  ResponseEntity<GenericRes>  createPrivilege(  @RequestBody RolesAndPrivillageRequest request)  throws Exception{
				return httpResponseUtils.prepareSuccessResponse(rolesAndPrivileService.createPrivilege(request));			
		}
		

}
