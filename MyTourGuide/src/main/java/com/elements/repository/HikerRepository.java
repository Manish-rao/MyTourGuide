package com.elements.repository;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elements.DO.HikerDO;
import com.elements.dto.HikerDTO;

public interface HikerRepository extends JpaRepository<HikerDO, Long>{
	
	public List<HikerDO> findByBookingDate(Date bookingDate);
}
