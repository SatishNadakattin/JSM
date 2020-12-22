package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.Taluk;

public interface TalukRepository extends CrudRepository<Taluk, Integer> {

	

	@Modifying
	@Transactional
	@Query(value ="update gen_std_taluk set name=?1, district_slno=?2, state_slno=?3, modified_by=?4, modified_on=?5, modified_at=?6 WHERE slno = ?7" , nativeQuery = true)
	int updateTalukRecord(String name, Long district, Long state, String modifiedBy, Date date, Time time, Long slno);
	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_taluk WHERE slno = ?1" , nativeQuery = true)
	int deleteTalukRecord(Long slno);

	@Query(value ="Select * FROM gen_std_taluk WHERE slno = ?1" , nativeQuery = true)
	Iterable<Taluk> findByTalukSlno(Long slno);


	List<Taluk> findByName(String name);

	Optional<Taluk> findBySlno(Long slno);


	

















}
