package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.Country;
import com.app.entity.Relationship;

public interface RelationshipRepository extends CrudRepository<Relationship, Integer>{

	Optional<Relationship> findBySlnoAndIsDelete(boolean b, Long slno);

	List<Relationship> findByRelationshipAndIsDelete(boolean b, String trim);
	
	@Modifying
	@Transactional
	@Query(value ="update bank_mst_relationship set relationship_code=?1, relationship=?2, modified_by=?3, modified_on=?4, modified_at=?5,is_active=?6 WHERE slno = ?7" , nativeQuery = true)
	int updateRelationshipRecord(String relationshipCode,String name, String modifiedBy, Date date, Time time, Boolean boolean1, Long slno);

	
	@Modifying
	@Transactional
	@Query(value ="update bank_mst_relationship set is_delete=?1 WHERE slno = ?2" , nativeQuery = true)
	int deleteRelationshipRecord(boolean b, Long slno);


	Iterable<Relationship> findByIsDelete(boolean b);
}
	
	
	

