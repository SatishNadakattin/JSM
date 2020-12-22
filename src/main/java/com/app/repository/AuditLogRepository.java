package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.AuditLog;

public interface AuditLogRepository extends CrudRepository<AuditLog, Integer> {

	
}
