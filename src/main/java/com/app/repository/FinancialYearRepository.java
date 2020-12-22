package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.FinancialYear;

public interface FinancialYearRepository extends CrudRepository<FinancialYear, Integer> {

	List<FinancialYear> findByFromYearAndToYear(String trim, String toYear);

	
	@Modifying
	@Transactional
	@Query(value ="update gen_std_financial_year set from_year=?1, to_year=?2 , modified_by=?3, modified_on=?4, modified_at=?5 WHERE slno = ?6" , nativeQuery = true)
	int updateFinancialYearRecord(String fromYear, String toYear, String modifiedBy, Date date, Time time, Long slno);

	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_financial_year WHERE slno = ?1" , nativeQuery = true)
	int deleteStateRecord(Long slno);

	
	Optional<FinancialYear> findBySlnoAndIsDelete(boolean b, Long financialYear);


	Optional<FinancialYear> findBySlno(Long slno);

}
