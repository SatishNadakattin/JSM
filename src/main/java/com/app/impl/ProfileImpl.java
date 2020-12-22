package com.app.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.entity.Features;
import com.app.entity.Modules;

import com.app.entity.Privileges;
import com.app.entity.Roles;
import com.app.request.RolesAndPrivillageRequest;
import com.app.service.ProfileService;
import com.app.util.AutoManager;


@Service
public class ProfileImpl extends AutoManager implements ProfileService {
	
	private static Logger logger = LoggerFactory.getLogger("master-log");

	@Override
	public Map<String, String> createModules(RolesAndPrivillageRequest request) {
		Map<String, String> info = new LinkedHashMap<>();
		try {
			
			List<Modules> tasks = new ArrayList<Modules>();
			tasks = super.modules.findByName(request.getName().trim());
			if (tasks.size() > 0) {
				info.put("status", "2");
				info.put("message", "Module name already exists");
				return info;
			}				
			Date date = new Date();
			Modules data = new Modules();
			data.setName(request.getName());
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			super.modules.save(data);
			
			info.put("status", "1");
			info.put("message", "Module created successfully");
			return info;
			
		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("error",  e.toString());
			return info;
		}

	}

	@Override
	public Map<String, Object> getModules(RolesAndPrivillageRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			//Iterable<Modules> tasks = super.modules.findAll();
			Pageable paging = PageRequest.of(request.getPageNo(), request.getPageSize());
	        Page<Modules> pagedResult =  super.modules.findAll(paging);				
				info.put("status", "1");
				info.put("message", "success");
				info.put("details", pagedResult);
				return info;
			

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
	 	    logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
	
	}
	}

	@Override
	public Map<String, Object> getModulesBySlno(RolesAndPrivillageRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Modules> tasks = super.modules.findBySlno(request.getSlno());
			if ( !tasks.isPresent()) {
				info.put("status", "2");
				info.put("message", "Module  not present");
				return info;
			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", tasks);
			return info;
		

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
	 	    logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
	
	}
	}

	@Override
	public Map<String, Object> updateModules(RolesAndPrivillageRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Modules> data = super.modules.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "Module  not present");
				return info;
			}

			List<Modules> tasks = new ArrayList<Modules>();
			tasks = super.modules.findByName(request.getName().trim());
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "Module name already exists");
				return info;
			}
			Date date = new Date();
			int retval = super.modules.updateModulesRecord(request.getName(),request.getModifiedBy(),new java.sql.Date(date.getTime()),new java.sql.Time(date.getTime()),request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "Module updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "Module slno not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
	 	    logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
	
		}
	}

	@Override
	public Map<String, Object> deleteModules(RolesAndPrivillageRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Modules> data = super.modules.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "Module  not present");
				return info;
			}

			int retval = super.modules.deleteModulesRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "Module deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "Module not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
	 	    logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
		}
	
	}

	@Override
	public Map<String, String> createFeatures(RolesAndPrivillageRequest request) {
		Map<String, String> info = new LinkedHashMap<>();
		try {
			
			Optional<Modules> tasks =super.modules.findBySlno(request.getModules());
			if (!tasks.isPresent()) {
				info.put("status", "2");
				info.put("message", "Module not exists");
				return info;
			}	
			Optional<Features> val =super.features.findByName(request.getName());
			if (val.isPresent()) {
				info.put("status", "2");
				info.put("message", "Feature Name already  exists");
				return info;
			}
			
			Date date = new Date();
			Features data = new Features();
			data.setName(request.getName());
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			data.setModules(tasks.get());
			super.features.save(data);
			
			info.put("status", "1");
			info.put("message", "Feature created successfully");
			return info;
			
		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("error",  e.toString());
			return info;
		}

	}

	@Override
	public Map<String, Object> getFeatures(RolesAndPrivillageRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			
			Pageable paging = PageRequest.of(request.getPageNo(), request.getPageSize());
	        Page<Features> pagedResult =  super.features.findAll(paging);				
		//	Iterable<Country> tasks = super.country.findAll();
				info.put("status", "1");
				info.put("message", "success");
				info.put("details", pagedResult);
				return info;
			

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
	 	    logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
	
	}

	}

	@Override
	public Map<String, Object> getFeaturesBySlno(RolesAndPrivillageRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Features> tasks = super.features.findBySlno(request.getSlno());
			if ( !tasks.isPresent()) {
				info.put("status", "2");
				info.put("message", "Features  not present");
				return info;
			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", tasks);
			return info;
		

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
	 	    logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
	
	}
	}

	@Override
	public Map<String, Object> updateFeatures(RolesAndPrivillageRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Features> res = super.features.findBySlno(request.getSlno());
			if ( !res.isPresent()) {
				info.put("status", "2");
				info.put("message", "Features  not present");
				return info;
			}
			
			Optional<Modules> value =super.modules.findBySlno(request.getModules());
			if (!value.isPresent()) {
				info.put("status", "2");
				info.put("message", "Module not exists");
				return info;
			}	
			
			List<Features> tasks = new ArrayList<Features>();
			tasks = super.features.findByNameAndModulesSlno(request.getName().trim(),request.getModules());
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "Features name already exists");
				return info;
			}
			Date date = new Date();
			int retval = super.features.updateFeaturesRecord(request.getName(),request.getModifiedBy(),new java.sql.Date(date.getTime()),new java.sql.Time(date.getTime()),request.getModules(),request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "Feature updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "Feature  not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
	 	    logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
	
		}
	}

	@Override
	public Map<String, Object> deleteFeatures(RolesAndPrivillageRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Features> data = super.features.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "Features  not present");
				return info;
			}

			int retval = super.features.deleteFeaturesRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "Features deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "Features not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
	 	    logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
		}
	}

	@Override
	public  String createRoles(RolesAndPrivillageRequest request) throws Exception {
	//	Map<String, String> info = new LinkedHashMap<>();
	
			
		
			Date date = new Date();
			Roles data = new Roles();
			data.setName(request.getName());
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			data.setIsActive(true);
			super.roles.save(data);
			
			
			//info.put("status", "SUCCESS");
		//	info.put("message", "Role created successfully");
			return "Role created successfully";

	}

	@Override
	public Page<Roles> getRoles(RolesAndPrivillageRequest request)  throws Exception{
			Pageable paging = PageRequest.of(request.getPageNo(), request.getPageSize(),Sort.by(request.getSort()));
	        Page<Roles> pagedResult =  super.roles.findAll(paging);				
				return  pagedResult;
	}

	@Override
	public Map<String, Object> getRolesBySlno(RolesAndPrivillageRequest request) {

			Map<String, Object> info = new LinkedHashMap<>();
			try {
				Optional<Roles> tasks = super.roles.findBySlno(request.getSlno());
				if ( !tasks.isPresent()) {
					info.put("status", "2");
					info.put("message", "Role  not present");
					return info;
				}
				info.put("status", "1");
				info.put("message", "success");
				info.put("details", tasks);
				return info;
			

			} catch (Exception e) {
				logger.error("Exception occured" + e);
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
		 	    logger.error(errors.toString());
				info.put("status", "0");
				info.put("message", "Something went wrong");
				return info;
		
		}
	}

	@Override
	public Map<String, Object> updateRoles(RolesAndPrivillageRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Roles> data = super.roles.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "Role  not present");
				return info;
			}

			List<Roles> tasks = new ArrayList<Roles>();
			tasks = super.roles.findByName(request.getName().trim());
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "Role name already exists");
				return info;
			}
			Date date = new Date();
			int retval = super.roles.updateRolesRecord(request.getName(),request.getModifiedBy(),new java.sql.Date(date.getTime()),new java.sql.Time(date.getTime()),request.getIsActive(),request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "Role updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "Role slno not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
	 	    logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
	
		}
	}

	@Override
	public Map<String, Object> deleteRoles(RolesAndPrivillageRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Roles> data = super.roles.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "Role  not present");
				return info;
			}

			int retval = super.roles.deleteRolesRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "Role deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "Role not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
	 	    logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
		}
	}

	@Override
	public String createPrivilege(RolesAndPrivillageRequest request) throws Exception {
		Optional<Modules> tasks =super.modules.findBySlno(request.getModules());
		if (!tasks.isPresent()) {
		
			return  "Module not exists";
		
		}	
		Optional<Features> val =super.features.findBySlno(request.getFeatures());
		if (!val.isPresent()) {
			return  "Features not exists";
			
		}
		
		
		Optional<Roles> roles =super.roles.findBySlno(request.getRoles());
		if (!roles.isPresent()) {
			return  "Roles not exists";
			
		}
		
		Date date = new Date();
		Privileges data = new Privileges();
		data.setModules(tasks.get());
		data.setFeatures(val.get());
		data.setRoles(roles.get());
		data.setView(request.getView());
		data.setCreate(request.getCreate());
		data.setUpdate(request.getUpdate());
		data.setDelete(request.getDelete());
		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(request.getCreatedBy());
		data.setModules(tasks.get());
		super.privilege.save(data);
		
	
		return "Privilege created successfully";
	}
	}

	


