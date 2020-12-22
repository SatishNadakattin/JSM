package com.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.News;
import com.app.entity.State;

public interface NewsRepository  extends CrudRepository<News, Integer> {

	List<News> findByTitle(String trim);

	Optional<News> findBySlno(Long slno);

	@Modifying
	@Transactional
	@Query(value ="DELETE FROM gen_std_news WHERE slno = ?1" , nativeQuery = true)
	int deleteNewsRecord(Long slno);

	List<News> findByTitleAndNewsDate(String trim, Date date);

	
	@Modifying
	@Transactional
	@Query(value ="update gen_std_news set title=?1, modified_by=?2, modified_on=?3, modified_at=?4,description=?5,news_date=?6,active=?7 WHERE slno = ?8" , nativeQuery = true)
	int updateNewsRecord(String title, String modifiedBy, Date date, Time time, String description, Date newsdate2,
			String string, Long slno);


}
