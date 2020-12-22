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
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entity.Roles;

public interface RolesRepository extends CrudRepository<Roles ,Integer> {

	List<Roles> findByName(String trim);

	Optional<Roles> findBySlno(Long slno);

	@Modifying
	@Transactional
	@Query(value ="update gen_std_roles set name=?1, modified_by=?2, modified_on=?3, modified_at=?4 ,is_active=?5 WHERE slno = ?6" , nativeQuery = true)
	int updateRolesRecord(String name, String modifiedBy, Date date, Time time, Boolean isActive, Long slno);

	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_roles WHERE slno = ?1" , nativeQuery = true)
	int deleteRolesRecord(Long slno);

	Page<Roles> findAll(Pageable paging);

}
