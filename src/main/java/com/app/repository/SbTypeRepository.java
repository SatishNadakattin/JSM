package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.SbType;

public interface SbTypeRepository extends CrudRepository<SbType, Integer> {



	@Modifying
	@Transactional
	@Query(value ="update gen_std_sb_type set name=?1, modified_by=?2, modified_on=?3, modified_at=?4,is_active=?5 WHERE slno = ?6" , nativeQuery = true)
	int updateSbTypeRecord(String name, String modifiedBy, Date date, Time time, Boolean boolean1, Long slno);

	@Modifying
	@Transactional
	@Query(value ="update FROM gen_std_sb_type set is_delete=?1 WHERE slno = ?2" , nativeQuery = true)
	int deleteSbTypeRecord(boolean b, Long slno);

	List<SbType> findByNameAndIsDelete(boolean b, String name);

	Optional<SbType> findBySlnoAndIsDelete(boolean b, Long slno);

	Iterable<SbType> findByIsDelete(boolean b);


	

}
