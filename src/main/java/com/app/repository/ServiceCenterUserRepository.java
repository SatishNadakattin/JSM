package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.ServiceCenter;
import com.app.entity.ServiceCenterUser;

public interface ServiceCenterUserRepository extends CrudRepository < ServiceCenterUser, Integer> {

	List<ServiceCenterUser> findByAccountNo(String accountNo);

	List<ServiceCenterUser> findByUsername(String username);

	Iterable<ServiceCenterUser> findBySlno(Long slno);
	
	
	@Modifying
	@Transactional
	@Query(value ="update gen_std_service_center_user set username=?1, modified_by=?2, modified_on=?3, modified_at=?4, address=?5, branch_slno=?6,  password=?7, contact_name=?8, pincode=?9, phone_no=?10, mobile_no=?11 ,email_id=?12 ,account_no =?13, service_center_slno=?14 WHERE slno = ?15" , nativeQuery = true)
	int updateserviceCenterUserRecord(String username, String modifiedBy, Date date, Time time, String address,
			Long branch, String password, String contactName, Integer pincode, String phoneNo, String mobileNo,
			String emailId, String accountNo,Long service_center, Long slno);

	
	
	@Query(value ="Select * FROM gen_std_service_center_user WHERE slno = ?1" , nativeQuery = true)
	Optional<ServiceCenterUser> findBySlnoValue(Long slno);

	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_service_center_user WHERE slno = ?1" , nativeQuery = true)
	int deleteBranchRecord(Long slno);



}
