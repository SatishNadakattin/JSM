package com.app.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.FeeParameter;
import com.app.entity.SbAccountsParameters;

public interface SbAccountsParametersRepository extends CrudRepository<SbAccountsParameters, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "update gen_std_sb_accounts_parameters set branch_slno=?1, sb_type_slno=?2, sb_min_balance=?3,sb_max_balance=?4, sb_roi=?5, sb_min_period=?6,service_charge=?7, penalty=?8, sb_min_bal_with_cheq_book_for_staff=?9, sb_min_bal_without_cheq_book_for_staff=?10, sb_roi_for_staff=?11, modified_by=?12, modified_on=?13, modified_at=?14,is_active=?15 WHERE slno = ?16", nativeQuery = true)
	int updateSbAccountsParametersRecord(Long branch, Long sbType, BigDecimal sbMinBalance, BigDecimal sbMaxBalance,
			BigDecimal sbRoi, BigDecimal sbMinPeriod, BigDecimal serviceCharge, BigDecimal penalty,
			BigDecimal sbMinBalWithCheqBookForStaff, BigDecimal sbMinBalWithoutCheqBookForStaff,
		    BigDecimal sbRoiForStaff, String modifiedBy, Date date, Time time, Boolean boolean1, Long slno);

	@Modifying
	@Transactional
	@Query(value ="update FROM gen_std_sb_accounts_parameters set is_delete=?1 WHERE slno = ?2" , nativeQuery = true)
	int deleteSbAccountsParametersRecord(boolean b, Long slno);

	@Query(value ="Select * FROM gen_std_sb_accounts_parameters WHERE is_delete=?1 AND slno = ?2" , nativeQuery = true)	
	Optional<SbAccountsParameters> findBySlnoValueAndIsDelete(boolean b, Long slno);

	Iterable<SbAccountsParameters> findByIsDelete(boolean b);


	Iterable<SbAccountsParameters> findBySlnoAndIsDelete(boolean b, Long slno);


	Optional<SbAccountsParameters> findByBranchSlnoAndSbTypeSlnoAndIsDelete(boolean b, Long branch, Long sbType);


	
}
