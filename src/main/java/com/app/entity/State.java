package com.app.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gen_std_state")
public class State {
	
	@Id
	@GeneratedValue
	private Long slno;

	private String name;
	
	private String CreatedBy;

	private String ModifiedBy;  
	

	@Column(name = "created_on", columnDefinition = "DATE")
	private Date createdOn;


	private Time createdAt;
	

    @Column(name = "modified_on", columnDefinition = "DATE")
	private Date ModifiedOn;
	

 
	private Time ModifiedAt;

	
	@ManyToOne( optional = false)
	@JoinColumn(name = "country_slno", nullable = false)
	private Country country;
	

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getModifiedBy() {
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	

	public Date getModifiedOn() {
		return ModifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		ModifiedOn = modifiedOn;
	}

	public Time getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}

	

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Time getModifiedAt() {
		return ModifiedAt;
	}

	public void setModifiedAt(Time modifiedAt) {
		ModifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "State [slno=" + slno + ", name=" + name + ", CreatedBy=" + CreatedBy + ", ModifiedBy=" + ModifiedBy
				+ ", createdOn=" + createdOn + ", createdAt=" + createdAt + ", ModifiedOn=" + ModifiedOn
				+ ", ModifiedAt=" + ModifiedAt + ", country=" + country + "]";
	}

	
	
	
	
	
}
