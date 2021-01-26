package com.elements.controller.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elements.DO.HikerDO;
import com.elements.DO.PackageDetailsDO;
import com.elements.dto.HikerDTO;
import com.elements.exception.AgeLimitNotInRangeException;
import com.elements.exception.EntityNotFoundException;
import com.elements.repository.PackageRepository;

@Service
public class HikerHelperService {
	private PackageRepository packageRepository;
	private final Logger logger = LoggerFactory.getLogger(HikerHelperService.class);
	@Autowired
	public HikerHelperService(PackageRepository packageRepository) {
		this.packageRepository = packageRepository;
	}
	 public HikerDO makeHikerDO(HikerDTO hikerDTO) throws EntityNotFoundException
	    {
		 	PackageDetailsDO packageDetailsDO = packageRepository.findByPackageName(hikerDTO.getPackageName());
		 	if(packageDetailsDO==null) {
		 		throw new EntityNotFoundException("Package does not exist"+hikerDTO.getPackageName());
		 	}
		 	if(packageDetailsDO.getAgeLimitLower()>hikerDTO.getAge() 
		 			|| hikerDTO.getAge()>packageDetailsDO.getAgeLimitHigher()) {
		 		throw new AgeLimitNotInRangeException("Age limit of hiker not within limit");
		 	}
		 	checkDetailsForOtherHikers(hikerDTO, packageDetailsDO.getPrice(), 
		 			packageDetailsDO.getAgeLimitLower(),packageDetailsDO.getAgeLimitHigher());
	        return new HikerDO(hikerDTO.getHikerName(), hikerDTO.getAge(), hikerDTO.getPackageName(),
	        		hikerDTO.getBookingDate(), hikerDTO.getOtherHikersAge(), hikerDTO.getTotalSum());
	    }


	    public HikerDTO makeHikerDTO(HikerDO hikerDO)
	    {
	    	return new HikerDTO(hikerDO.getId(), hikerDO.getHikerName(), hikerDO.getAge(), hikerDO.getPackageName(),
	        		hikerDO.getBookingDate(), hikerDO.getOtherHikerDetails(), hikerDO.getTotalSum());
			
	    }
	    
	    public void checkDetailsForOtherHikers(HikerDTO hikerDto, BigDecimal price, int ageLimitLower, int ageLimitHigher) {
	    	if(hikerDto.getOtherHikersAge().size()>0) {
	    		boolean ageLimitCheck = extractAgeFromDetails(hikerDto.getOtherHikersAge())
	    		.stream().allMatch(s -> s<=ageLimitHigher && s>=ageLimitLower);
	    		if(!ageLimitCheck) {
	    			throw new AgeLimitNotInRangeException("Age limit of one of the hikers is not within limit");
	    		}else {
	    			hikerDto.setTotalSum(price.multiply(new BigDecimal(hikerDto.getOtherHikersAge().size()+1)));
	    		}
	    	}else {
	    		hikerDto.setTotalSum(price);
	    	}
	    }

		public List<Integer> extractAgeFromDetails(List<String> otherHikerDetails){
			List<Integer> ageDetails = new ArrayList<>();
			for(String s:otherHikerDetails) {
				logger.info("String"+s);
				logger.info("My failed attempt:"+s.substring(s.lastIndexOf(":")+1));
				ageDetails.add(Integer.parseInt(s.substring(s.lastIndexOf(":")+1)));
			}
			return ageDetails;
		}

}
