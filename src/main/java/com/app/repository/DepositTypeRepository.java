package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.DepositType;

public interface DepositTypeRepository extends CrudRepository<DepositType, Integer> {

	
	@Modifying
	@Transactional
	@Query(value ="update gen_std_deposit_type set name=?1, modified_by=?2, modified_on=?3, modified_at=?4 WHERE slno = ?5" , nativeQuery = true)
	int updateSbTypeRecord(String name, String modifiedBy, Date date, Time time, Long slno);

	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_deposit_type WHERE slno = ?1" , nativeQuery = true)	
	int deleteDepositTypeRecord(Long slno);

	List<DepositType> findByNameAndIsDelete(boolean b, String name);


	Iterable<DepositType> findByIsDelete(boolean b);

	Optional<DepositType> findBySlnoAndIsDelete(boolean b, Long slno);



}
