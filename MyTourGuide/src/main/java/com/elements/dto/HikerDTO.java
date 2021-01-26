package com.elements.dto;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.elements.DO.HikerDO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HikerDTO {
	
	@JsonIgnore
	private Long id;
	
    @JsonProperty("name")
	@NotNull(message = "Hiker Name can not be null!")
	private String hikerName;
	
    @JsonProperty("age")
	@NotNull(message = "Hiker Age can not be null!")
	private Integer age;
	
    @JsonProperty("packageName")
	@NotNull(message = "Package Name can not be null!")
	private String packageName;
	
    @JsonProperty("bookingDate")
	@NotNull(message = "Booking Date can not be null!")
	@FutureOrPresent(message = "Booking Date cannot be in the past")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
	private	Date bookingDate;
	
    @JsonProperty("otherHikerDetails")
	//list of hikers with ages
	private List<String> otherHikerDetails;
	
	private BigDecimal totalSum;

	private HikerDTO() {	
	}
	
	/*
	 * public static HikerDTOBuilder newBuilder() { return new HikerDTOBuilder(); }
	 */
	

	public HikerDTO(Long id, @NotNull(message = "Hiker Name can not be null!") String hikerName,
			@NotNull(message = "Hiker Age can not be null!") Integer age,
			@NotNull(message = "Package Name can not be null!") String packageName,
			@NotNull(message = "Booking Date can not be null!") @FutureOrPresent(message = "Booking Date cannot be in the past") Date bookingDate,
			List<String> otherHikersAge, BigDecimal totalSum) {
		this.id = id;
		this.hikerName = hikerName;
		this.age = age;
		this.packageName = packageName;
		this.bookingDate = bookingDate;
		this.otherHikerDetails = otherHikersAge;
		this.totalSum = totalSum;
	}



	@JsonProperty
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("hikerName")
	public String getHikerName() {
		return hikerName;
	}

	@JsonProperty("hikerName")
	public void setHikerName(String hikerName) {
		this.hikerName = hikerName;
	}

	@JsonProperty("hikerAge")
	public Integer getAge() {
		return age;
	}

	@JsonProperty("hikerAge")
	public void setAge(Integer age) {
		this.age = age;
	}

	@JsonProperty("otherHikerDetails")
	public List<String> getOtherHikersAge() {
		return otherHikerDetails;
	}

	@JsonProperty("otherHikerDetails")
	public void setOtherHikersAge(List<String> otherHikersAge) {
		this.otherHikerDetails = otherHikersAge;
	}

	
	public BigDecimal getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(BigDecimal totalSum) {
		this.totalSum = totalSum;
	}


	@JsonProperty("packageName")
	public String getPackageName() {
		return packageName;
	}


	@JsonProperty("packageName")
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	@JsonProperty("bookingDate")
	public Date getBookingDate() {
		return bookingDate;
	}


	@JsonProperty("bookingDate")
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	/*public static class HikerDTOBuilder
    {
		private Long id;
		private String hikerName;
		private Integer age;
		private String packageName;
		private	Date bookingDate;
		private String[] otherHikerDetails;
		private BigDecimal totalSum;
		
        public HikerDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }

        public HikerDTOBuilder setHikerName(String hikerName) {
			this.hikerName = hikerName;
			return this;
		}

		public HikerDTOBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public HikerDTOBuilder setPackageName(String packageName) {
			this.packageName = packageName;
			return this;
		}

		public HikerDTOBuilder setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
			return this;
		}
		
		public HikerDTOBuilder setOtherHikerDetails(List<String> otherHikerDetails) {
			this.otherHikerDetails = (String[]) otherHikerDetails.toArray();
			return this;
		}

		public HikerDTOBuilder setConvertible(BigDecimal totalSum) {
			this.totalSum = totalSum;
			return this;
		}

		public HikerDTO createHikerDTO()
        {
            return new HikerDTO(id, hikerName, age, packageName, bookingDate, otherHikerDetails, totalSum);
        }*/

		

    
	
}
