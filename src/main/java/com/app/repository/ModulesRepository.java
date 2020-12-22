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

import com.app.entity.Modules;

public interface ModulesRepository extends CrudRepository<Modules, Integer> {

	List<Modules> findByName(String trim);

	Optional<Modules> findBySlno(Long slno);

	@Modifying
	@Transactional
	@Query(value ="update gen_std_modules set name=?1, modified_by=?2, modified_on=?3, modified_at=?4 WHERE slno = ?5" , nativeQuery = true)
	int updateModulesRecord(String name, String modifiedBy, Date date, Time time, Long slno);
	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_modules WHERE slno = ?1" , nativeQuery = true)
	int deleteModulesRecord(Long slno);

	Page<Modules> findAll(Pageable paging);

	

}
