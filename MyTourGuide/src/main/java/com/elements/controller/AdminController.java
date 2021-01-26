package com.elements.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elements.dto.HikerDTO;
import com.elements.service.ifc.AdminService;

@RestController
@RequestMapping("/admin")
@Secured("ADMIN")
@Validated
public class AdminController {
	
	private final AdminService adminService;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	public AdminController(final AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("/{bookingDate}")
	public List<HikerDTO> getBookingsByDate(@Valid @PathVariable  @DateTimeFormat(iso=ISO.DATE) String bookingDate) throws ParseException{
		Date date=new SimpleDateFormat("dd-MM-yyyy").parse(bookingDate);
		logger.info("Entered this message"+bookingDate);
		List<HikerDTO> hikers =  adminService.findByBookingDate(date);
		for(HikerDTO hikerDTO:hikers) {
			logger.info("Date:"+hikerDTO.getBookingDate());
		}
		return hikers;
	}
}
