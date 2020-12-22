package com.app.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "gen_std_news")
public class News {
	
	
	@Id
	@GeneratedValue
	private Long slno;

	private String title;
	
	private String active;
	
	private String createdBy;

	private String modifiedBy;  
	
	private Time createdAt;
	
	private Time  modifiedAt;
	
	@Column(columnDefinition="TEXT")
	private String Description;
	
	@Column(name = "created_on", columnDefinition = "DATE")
	private Date createdOn;

	@Column(name = "modified_on", columnDefinition = "DATE")
	private Date modifiedOn;
 
	@Column(name = "news_date", columnDefinition = "DATE")
	private Date newsDate;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Time getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}

	public Time getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Time modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	@Override
	public String toString() {
		return "News [slno=" + slno + ", title=" + title + ", active=" + active + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", Description=" + Description + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ ", newsDate=" + newsDate + "]";
	}

	
	
	

}
