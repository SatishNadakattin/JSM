package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.District;

public interface DistrictRepository extends CrudRepository<District, Integer> {

	List<District> findByName(String trim);

	Iterable<District> findBySlno(Long long1);
	
	@Modifying
	@Transactional
	@Query(value ="update gen_std_district set name=?1, modified_by=?2, modified_on=?3, modified_at=?4, description=?5, state_slno=?6 WHERE slno = ?7" , nativeQuery = true)
	int updateDistrictRecord(String name, String modified_by, Date date, Time time, String description, Long stateslno, Long slno);

	
	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_district WHERE slno = ?1" , nativeQuery = true)
	int deleteDistrictRecord(Long slno);

	
	@Query(value ="Select * FROM gen_std_district WHERE slno = ?1" , nativeQuery = true)
	Optional<District> findBySlnoValue(Long slno);

	@Query(value ="Select * FROM gen_std_district WHERE slno = ?1" , nativeQuery = true)
	Optional<District> findBySlnoValue(String name);

	@Query(value ="Select * FROM gen_std_district WHERE slno = ?1" , nativeQuery = true)
	Optional<District> findByDistrictSlno(Long district);

}
