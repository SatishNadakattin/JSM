package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.Features;

public interface FeaturesRepository extends CrudRepository<Features ,Integer>{

	Optional<Features> findByName(String name);

	Optional<Features> findBySlno(Long slno);

	List<Features> findByNameAndModulesSlno(String trim, Long modules);

    @Modifying
	@Transactional
	@Query(value ="update gen_std_features set name=?1, modified_by=?2, modified_on=?3, modified_at=?4 ,modules_slno=?5 WHERE slno = ?6" , nativeQuery = true)
	int updateFeaturesRecord(String name, String modifiedBy, Date date, Time time, Long modules, Long slno);

	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_features WHERE slno = ?1" , nativeQuery = true)
	int deleteFeaturesRecord(Long slno);

	Page<Features> findAll(Pageable paging);

}