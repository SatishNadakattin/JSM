package com.app.request;

import org.springframework.data.domain.Sort;

public class RolesAndPrivillageRequest {
	
	
     private Long slno;
	
	private String name;
	
	private String description;
	
	private String createdBy;
	
	private String modifiedBy;
	
	private Boolean isActive;
	
	private Long modules;
	
	private Long features;
	
	private Long roles;
	
	private Boolean view;
	
	private Boolean create;
	private Boolean update;
	private Boolean delete;
	
	private Integer pageNo;
	
	private Integer pageSize;
	
	private String sort;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getName() {
		return name;
	}

	

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getModules() {
		return modules;
	}

	public void setModules(Long modules) {
		this.modules = modules;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Long getFeatures() {
		return features;
	}

	public void setFeatures(Long features) {
		this.features = features;
	}

	public Long getRoles() {
		return roles;
	}

	public void setRoles(Long roles) {
		this.roles = roles;
	}

	public Boolean getView() {
		return view;
	}

	public void setView(Boolean view) {
		this.view = view;
	}

	public Boolean getCreate() {
		return create;
	}

	public void setCreate(Boolean create) {
		this.create = create;
	}

	public Boolean getUpdate() {
		return update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "RolesAndPrivillageRequest [slno=" + slno + ", name=" + name + ", description=" + description
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", isActive=" + isActive + ", modules="
				+ modules + ", features=" + features + ", roles=" + roles + ", view=" + view + ", create=" + create
				+ ", update=" + update + ", delete=" + delete + ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", sort=" + sort + "]";
	}

	
	


	
	
	
	


}
