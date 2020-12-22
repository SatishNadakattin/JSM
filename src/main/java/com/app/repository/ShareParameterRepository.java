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
import com.app.entity.ShareParameter;

public interface ShareParameterRepository extends CrudRepository<ShareParameter, Integer> {

		
	@Modifying
	@Transactional
	@Query(value ="update gen_std_share_parameter set member_type_slno=?1, share_value=?2, min_share=?3,max_share=?4,dividend_declared=?5, modified_by=?6, modified_on=?7, modified_at=?8, is_active=?9 WHERE slno = ?10" , nativeQuery = true)		
	int updateShareParameterRecord(Long memberType, Float shareValue, Integer minShare, Integer maxShare,
			Float dividendDeclared, String modifiedBy, Date date, Time time, Boolean boolean1, Long slno);

	@Modifying
	@Transactional
	@Query(value ="update FROM gen_std_share_parameter set is_delete=?1 WHERE slno = ?2" , nativeQuery = true)	
	int deleteShareParameterRecord(boolean b, Long slno);


	@Query(value ="Select * FROM gen_std_share_parameter WHERE is_delete=?1 AND slno = ?2" , nativeQuery = true)
	Optional<ShareParameter> findBySlnoValueAndIsDelete(boolean b, Long slno);

	Iterable<ShareParameter> findByIsDelete(boolean b);

	Optional<ShareParameter> findByMemberTypeSlnoAndIsDelete(boolean b, Long memberType);



	Iterable<ShareParameter> findBySlnoAndIsDelete(boolean b, Long slno);

	





		

}
