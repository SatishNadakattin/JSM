package com.app.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.app.entity.Roles;
import com.app.request.RolesAndPrivillageRequest;

public interface ProfileService {

	Map<String, String> createModules(RolesAndPrivillageRequest request);

	Map<String, Object> getModules(RolesAndPrivillageRequest request);

	Map<String, Object> getModulesBySlno(RolesAndPrivillageRequest request);

	Map<String, Object> updateModules(RolesAndPrivillageRequest request);

	Map<String, Object> deleteModules(RolesAndPrivillageRequest request);

	Map<String, String> createFeatures(RolesAndPrivillageRequest request);

	Map<String, Object> getFeatures(RolesAndPrivillageRequest request);

	Map<String, Object> getFeaturesBySlno(RolesAndPrivillageRequest request);

	Map<String, Object> updateFeatures(RolesAndPrivillageRequest request);

	Map<String, Object> deleteFeatures(RolesAndPrivillageRequest request);

	Object  createRoles(RolesAndPrivillageRequest request)throws Exception ;

	Page<Roles> getRoles(RolesAndPrivillageRequest request) throws Exception;

	Map<String, Object> getRolesBySlno(RolesAndPrivillageRequest request);

	Map<String, Object> updateRoles(RolesAndPrivillageRequest request);

	Map<String, Object> deleteRoles(RolesAndPrivillageRequest request);

	Object createPrivilege(RolesAndPrivillageRequest request)throws Exception;

}
