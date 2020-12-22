package com.app.repository;


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.app.entity.LateFeeParameter;

public interface LateFeeParameterRepository extends CrudRepository<LateFeeParameter, Integer>{


	@Modifying
	@Transactional
	@Query(value ="update gen_std_late_fee_parameter set compounding_period_slno=?1, grace_period=?2, late_fees=?3, modified_by=?4, modified_on=?5, modified_at=?6 WHERE slno = ?7" , nativeQuery = true)
	int updateLateFeeParameterRecord(Long compoundingPeriod, Integer gracePeriod, BigDecimal lateFees,
			String modifiedBy, Date date, Time time, Long slno);

	@Query(value ="Select * FROM gen_std_late_fee_parameter WHERE is_delete=?1 AND slno = ?2" , nativeQuery = true)
	Optional<LateFeeParameter> findBySlnoValueAndIsDelete(boolean b, Long slno);

	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_late_fee_parameter WHERE slno = ?1" , nativeQuery = true)
	int deleteLateFeeParameter(Long slno);

	List<LateFeeParameter> findByCompoundingPeriodSlnoAndIsDelete(boolean b, Long compoundingPeriod);


	Iterable<LateFeeParameter> findByIsDelete(boolean b);


	Iterable<LateFeeParameter> findBySlnoAndIsDelete(boolean b, Long slno);

	
	
}
