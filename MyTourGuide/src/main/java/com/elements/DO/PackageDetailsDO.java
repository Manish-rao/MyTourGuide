package com.elements.DO;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="package_details")
public class PackageDetailsDO {
	
	@Id
    @Column(name="package_id")
	private String id;
	
	@Column(name="package_name")
	private String packageName;
	
	@Column(name="start_time")
	private String startTime;
	
	@Column(name="end_time")
	private String endTime;
	
	@Column(name="age_limit_lower")
	private int ageLimitLower;
	
	@Column(name="age_limit_higher")
	private int ageLimitHigher;
	
	@Column(name="price",scale = 2)
	private BigDecimal price;

	private PackageDetailsDO(){
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getAgeLimitLower() {
		return ageLimitLower;
	}

	public void setAgeLimitLower(int ageLimitLower) {
		this.ageLimitLower = ageLimitLower;
	}

	public int getAgeLimitHigher() {
		return ageLimitHigher;
	}

	public void setAgeLimitHigher(int ageLimitHigher) {
		this.ageLimitHigher = ageLimitHigher;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
}
