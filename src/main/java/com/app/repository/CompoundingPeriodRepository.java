package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.Branch;
import com.app.entity.CompoundingPeriod;

public interface CompoundingPeriodRepository extends CrudRepository<CompoundingPeriod, Integer> {
		
    @Modifying
    @Transactional
    @Query(value = "UPDATE gen_std_compounding_period set name=?1, modified_by=?2, modified_on=?3, modified_at=?4 WHERE slno = ?5" , nativeQuery = true)
	int updateCompoundingPeriodRecord(String name, String modifiedBy, Date date, Time time, Long slno);

    @Modifying
	@Transactional
    @Query(value ="DELETE FROM gen_std_compounding_period WHERE slno = ?1" , nativeQuery = true)
	int deleteCompoundingPeriodRecord(Long slno);

	@Query(value ="Select * FROM gen_std_compounding_period WHERE is_delete=?1 AND slno = ?2" , nativeQuery = true)
	Optional<CompoundingPeriod> findBySlnoValueAndIsDelete(boolean b, Long compoundingPeriod);

	List<CompoundingPeriod> findByNameAndIsDelete(boolean b, String name);


	Iterable<CompoundingPeriod> findByIsDelete(boolean b);


	Optional<CompoundingPeriod> findBySlnoAndIsDelete(boolean b, Long slno);

	

	


}
