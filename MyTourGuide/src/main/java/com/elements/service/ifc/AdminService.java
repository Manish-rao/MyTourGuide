package com.elements.service.ifc;

import java.util.Date;
import java.util.List;

import com.elements.DO.HikerDO;
import com.elements.dto.HikerDTO;

public interface AdminService {
	List<HikerDTO> findAll();
	
	List<HikerDTO> findByBookingDate(Date date);
}
