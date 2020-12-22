package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.IpAddress;
import com.app.entity.State;

public interface StateRepository extends CrudRepository<State, Integer> {

	List<State> findByName(String name);

	Iterable<State> findBySlno( Long slno);

	@Modifying
	@Transactional
	@Query(value ="update gen_std_state set name=?1, modified_by=?2, modified_on=?3, modified_at=?4 ,country_slno=?5 WHERE slno = ?6" , nativeQuery = true)
	int updateStateRecord(String name, String modified_by, Date date, Time time, Long slno, Long long1);

	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_state WHERE slno = ?1" , nativeQuery = true)
	int deleteStateRecord(Long slno);

	List<State> findByNameAndCountrySlno(String trim, Long country);

	@Query(value ="Select * FROM gen_std_state WHERE slno = ?1" , nativeQuery = true)
	Optional<State> findBySlnoValue(Long state);

}
