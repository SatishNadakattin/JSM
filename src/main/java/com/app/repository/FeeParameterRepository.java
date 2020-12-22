package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.FeeParameter;
import com.app.entity.ShareParameter;

public interface FeeParameterRepository extends CrudRepository<FeeParameter, Integer> {


	@Modifying
	@Transactional
	@Query(value ="update gen_std_fee_parameter set member_type_slno=?1, share_value=?2, admin_fee=?3,death_fund=?4,bulding_fund=?5, modified_by=?6, modified_on=?7, modified_at=?8, is_active=?9 WHERE slno = ?10" , nativeQuery = true)		
	int updateFeeParameterRecord(Long memberType, Float shareValue, Integer adminFee, Integer deathFund,
			Integer buldingFund, String modifiedBy, Date date, Time time, Boolean boolean1, Long slno);	
	
	@Modifying
	@Transactional
	@Query(value ="update FROM gen_std_fee_parameter set is_delete=?1 WHERE slno = ?2" , nativeQuery = true)	
	int deleteFeeParameterRecord(boolean b, Long slno);
	
	@Query(value ="Select * FROM gen_std_fee_parameter WHERE is_delete=?1 AND slno = ?2" , nativeQuery = true)
	Optional<FeeParameter> findBySlnoValueAndIsDelete(boolean b, Long slno);

	Optional<FeeParameter> findByMemberTypeSlnoAndIsDelete(boolean b, Long memberType);

	Iterable<FeeParameter> findByIsDelete(boolean b);

	Iterable<FeeParameter> findBySlnoAndIsDelete(boolean b, Long slno); 

	


}
