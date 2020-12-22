package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.IpAddress;

public interface IpAddressRepository extends CrudRepository<IpAddress, Integer> {

	List<IpAddress> findByIpAddress(String trim);

	List<IpAddress> findByIpAddressAndBranchSlno(String trim, Long branch);

	Iterable<IpAddress> findBySlno(Long slno);
	
	@Modifying
	@Transactional
	@Query(value ="update gen_std_ip_address set ip_address=?1, modified_by=?2, modified_on=?3, modified_at=?4, is_active=?5, branch_slno=?6 WHERE slno = ?7" , nativeQuery = true)
	int updateIpAddressRecord(String ipAddress, String modifiedBy, Date date, Time time, Boolean isActive, Long branch,
			Long slno);

	@Query(value ="Select * FROM gen_std_ip_address WHERE slno = ?1" , nativeQuery = true)
	Optional<IpAddress> findBySlnoValue(Long slno);

	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_ip_address WHERE slno = ?1" , nativeQuery = true)
	int deleteIpAddressRecord(Long slno);

	Iterable<IpAddress> findByIsActive(Boolean isActive);

	@Modifying
	@Transactional
	@Query(value ="update gen_std_ip_address set is_active=?1, modified_by=?2, modified_on=?3, modified_at=?4 WHERE  branch_slno=?5", nativeQuery = true)
	int updateenableORDisableOnBranch(Boolean isActive, String modifiedBy, Date date, Time time, Long branch);

}
