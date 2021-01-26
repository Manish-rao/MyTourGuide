package com.elements.DO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="hiker_details")
public class HikerDO {
	@Id
    @GeneratedValue
    @Column(name="hiker_id")
	private Long id;
	
	@Column(name="name")
	private String hikerName;
	
	@Column(name="age")
	private Integer age;
	
	//mapped with package_details table
	//@OneToOne
	//@JoinColumn(name="package_id")
	private String packageName;
	
	@Column(name="booking_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Temporal(TemporalType.DATE)
	private	Date bookingDate;
	
    
	//list of hikers with ages
	@ElementCollection
	private List<String>  otherHikerDetails;
	
	@Column(name="totalSum")
	private BigDecimal totalSum;

	private HikerDO() {
		
	}
	
	public HikerDO(String hikerName, Integer age, String packageName, Date bookingDate,
			List<String> otherHikerDetails, BigDecimal totalSum) {
		this.hikerName = hikerName;
		this.age = age;
		this.packageName = packageName;
		this.bookingDate = bookingDate;
		this.otherHikerDetails = otherHikerDetails;
		this.totalSum = totalSum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHikerName() {
		return hikerName;
	}

	public void setHikerName(String hikerName) {
		this.hikerName = hikerName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public List<String> getOtherHikerDetails() {
		return otherHikerDetails;
	}

	public void setOtherHikerDetails(List<String> otherHikerDetails) {
		this.otherHikerDetails = otherHikerDetails;
	}

	public BigDecimal getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(BigDecimal totalSum) {
		this.totalSum = totalSum;
	}
	
	
}
