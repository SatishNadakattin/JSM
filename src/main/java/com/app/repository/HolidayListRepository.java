package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.HolidayList;
import com.app.entity.SbAccountsParameters;

public interface HolidayListRepository extends CrudRepository<HolidayList, Integer>{

	
	
	
	@Query(value ="Select * FROM gen_std_holiday_list WHERE holiday_date = ?1" , nativeQuery = true)
	List<HolidayList> findByDate(java.util.Date simpaleDate);

	
	@Modifying
	@Transactional
	@Query(value = "update gen_std_holiday_list set branch_slno=?1, financial_year_slno=?2,holiday_date=?3,holiday_name=?4, modified_by=?5, modified_on=?6, modified_at=?7 WHERE slno = ?8", nativeQuery = true)
	int updateHolidayListRecord(Long branch, Long financialYear, java.util.Date simpaleDate, String holidayName,
			String modifiedBy, Date date, Time time, Long slno);
	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_holiday_list WHERE slno = ?1" , nativeQuery = true)
	int deleteHolidayList(Long slno);	

	
	@Query(value ="Select * FROM gen_std_holiday_list WHERE is_delete=?1 AND slno = ?2" , nativeQuery = true)
	Optional<HolidayList> findBySlnoValueAndIsDelete(boolean b, Long slno);


	Iterable<HolidayList> findByIsDelete(boolean b);


	Iterable<HolidayList> findBySlnoAndIsDelete(boolean b, Long slno);


	
}
