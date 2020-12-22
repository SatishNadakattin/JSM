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
import com.app.entity.District;
import com.app.entity.Taluk;

public interface BranchRepository extends CrudRepository<Branch, Integer> {



	Optional<Branch> findBySlno(Long slno);

	@Modifying
	@Transactional
	@Query(value ="update gen_std_branch set name=?1, modified_by=?2, modified_on=?3, modified_at=?4, address=?5, state_slno=?6,  code=?7, contact_name=?8, pincode=?9, phone_no=?10, mobile_no=?11 ,email_id=?12,district_slno=?13,taluk_slno=?14,city=?15,is_active=?16  WHERE slno = ?17" , nativeQuery = true)
	int updateBranchRecord(String name, String modifiedBy, Date date, Time time, String address, Long state,
			String code, String contactName, Integer pincode, String phoneNo, String mobileNo, String emailId,
			Long district, Long taluk, String city, Boolean isActive, Long slno);

	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_branch WHERE slno = ?1" , nativeQuery = true)
	int deleteBranchRecord(Long slno);

	
	@Query(value ="Select * FROM gen_std_branch WHERE is_delete=?1 AND slno = ?2" , nativeQuery = true)
	Optional<Branch> findBySlnoValueAndIsDelete(boolean b, Long branch);

	List<Branch> findByNameAndStateSlnoAndDistrictSlnoAndTalukSlno(String trim, Long state, Long district, Long taluk);

	@Query(value ="Select * FROM gen_std_branch WHERE slno = ?1" , nativeQuery = true)
	Iterable<Branch> findByBranchSlno(Long slno);

	@Query(value ="Select * FROM gen_std_branch WHERE slno = ?1" , nativeQuery = true)
	Optional<Branch> findBySlnoValue(Long branch);


}
