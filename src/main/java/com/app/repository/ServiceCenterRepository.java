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
import com.app.entity.ServiceCenter;

public interface ServiceCenterRepository extends CrudRepository <ServiceCenter , Integer>{

	List<ServiceCenter> findByNameAndStateSlnoAndBranchSlno(String trim, Long state, Long branch);

	@Query(value ="Select * FROM gen_std_service_center WHERE slno = ?1" , nativeQuery = true)
	Iterable<ServiceCenter> findBySlnoValue(Long slno);

	Optional<ServiceCenter> findBySlno(Long slno);


	@Modifying
	@Transactional
	@Query(value ="update gen_std_service_center set name=?1, modified_by=?2, modified_on=?3, modified_at=?4, address=?5, state_slno=?6,  code=?7, contact_name=?8, pincode=?9, phone_no=?10, mobile_no=?11 ,email_id=?12 ,branch_slno=?13 WHERE slno = ?14" , nativeQuery = true)
	int updateServiceCenterRecord(String name, String modifiedBy, Date date, Time time, String address, Long state,
			String code, String contactName, Integer pincode, String phoneNo, String mobileNo, String emailId,
			Long branch, Long slno);

	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_service_center WHERE slno = ?1" , nativeQuery = true)
	int deleteStateRecord(Long slno);

	Optional<ServiceCenter> findBySlnoAndIsDelete(boolean b, Long serviceCenter);

}
