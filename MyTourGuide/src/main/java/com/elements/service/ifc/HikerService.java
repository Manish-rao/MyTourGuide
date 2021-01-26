package com.elements.service.ifc;

import java.util.List;

import com.elements.DO.HikerDO;
import com.elements.dto.HikerDTO;
import com.elements.exception.ConstraintsViolationException;
import com.elements.exception.EntityNotFoundException;

public interface HikerService {
	HikerDO find(Long hikerId) throws EntityNotFoundException;

	HikerDO create(HikerDO hikerDo) throws ConstraintsViolationException; 

	void delete(Long hikerId) throws EntityNotFoundException;

	void update(HikerDTO hikerDTO) throws EntityNotFoundException;

	List<HikerDTO> findAll();
	
}
