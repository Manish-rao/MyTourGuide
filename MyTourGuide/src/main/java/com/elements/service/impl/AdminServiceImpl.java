package com.elements.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elements.DO.HikerDO;
import com.elements.controller.mapper.HikerHelperService;
import com.elements.dto.HikerDTO;
import com.elements.exception.EntityNotFoundException;
import com.elements.repository.HikerRepository;
import com.elements.service.ifc.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	private HikerRepository hikerRepository;
	private HikerHelperService hikerMapper;
			
	@Autowired
	public AdminServiceImpl(com.elements.repository.HikerRepository hikerRepository, HikerHelperService hikerMapper) {
		this.hikerRepository = hikerRepository;
		this.hikerMapper = hikerMapper;
	}

	@Override
	public List<HikerDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HikerDTO> findByBookingDate(Date bookingDate) {
		// TODO Auto-generated method stub
		List<HikerDO> hikerDOs =  hikerRepository.findByBookingDate(bookingDate);
		if(hikerDOs.isEmpty()) {
			throw new EntityNotFoundException("No records found for this date");
		}
		List<HikerDTO> hikerDtos = new ArrayList<>();
		for(HikerDO hikerDO:hikerDOs) {
			HikerDTO hikerDTO = hikerMapper.makeHikerDTO(hikerDO);
			hikerDtos.add(hikerDTO);
		}
		return hikerDtos;
	}

}
