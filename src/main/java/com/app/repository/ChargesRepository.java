package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.Charges;

public interface ChargesRepository extends CrudRepository<Charges, Integer> {
	
    @Modifying
    @Transactional
    @Query(value = "update gen_std_charges set charges=?1, modified_by=?2,modified_on=?3,modified_at=?4 WHERE slno=?5" , nativeQuery = true)
	int updateChargesRecord(String charges, String modifiedBy, Date date, Time time, Long slno);

    @Modifying 
    @Transactional
    @Query(value = "delete From gen_std_charges WHERE slno=?1" , nativeQuery = true)
	int deleteChargesRecord(Long slno);

	List<Charges> findByChargesAndIsDelete(boolean b, String charges);

	
	Iterable<Charges> findByIsDelete(boolean b);

	Optional<Charges> findBySlnoAndIsDelete(boolean b, Long slno);

}
