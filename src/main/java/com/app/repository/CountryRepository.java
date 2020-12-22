package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entity.Country;

public interface CountryRepository extends PagingAndSortingRepository<Country, Integer>  {
	

	List<Country> findByName(String trim);

	Optional<Country> findBySlno(Long slno);
	
	
	
	@Modifying
	@Transactional
	@Query(value ="update gen_std_country set name=?1, modified_by=?2, modified_on=?3, modified_at=?4 WHERE slno = ?5" , nativeQuery = true)
	int updateCountryRecord(String name, String modifiedBy, Date date, Time time, Long slno);

	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_country WHERE slno = ?1" , nativeQuery = true)
	int deleteCountryRecord(Long slno);



}
