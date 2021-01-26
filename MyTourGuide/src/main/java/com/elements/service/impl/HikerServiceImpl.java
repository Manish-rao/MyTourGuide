package com.elements.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.elements.DO.HikerDO;
import com.elements.dto.HikerDTO;
import com.elements.exception.ConstraintsViolationException;
import com.elements.exception.EntityNotFoundException;
import com.elements.repository.HikerRepository;
import com.elements.service.ifc.HikerService;

@Service
public class HikerServiceImpl implements HikerService{

	private static org.slf4j.Logger LOG = LoggerFactory.getLogger(HikerServiceImpl.class);

    private final HikerRepository hikerRepository;


    public HikerServiceImpl(final HikerRepository hikerRepository)
    {
        this.hikerRepository = hikerRepository;
    }
	
	@Override
	public HikerDO find(Long hikerId) throws EntityNotFoundException {
		Optional<HikerDO> hikerDO = hikerRepository.findById(hikerId);
        if (!hikerDO.isPresent())
        {
            throw new EntityNotFoundException("Could not find entity with id: " + hikerId);
        }
        return hikerDO.get();
	}

	@Override
	public HikerDO create(HikerDO hikerDo) throws ConstraintsViolationException {
		HikerDO hiker;
        try
        {
        	hiker = hikerRepository.save(hikerDo);
        }
        catch (DataIntegrityViolationException | ConstraintViolationException e)
        {
            LOG.warn("Some constraints are thrown due to car creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return hiker;
	}

	@Override
	@Transactional
	public void delete(Long hikerId) throws EntityNotFoundException {
		find(hikerId);
		hikerRepository.deleteById(hikerId);
	}

	@Override
	@Transactional
	public void update(HikerDTO hikerDTO) throws EntityNotFoundException {
		HikerDO hikerDO = find(hikerDTO.getId());
		hikerDO.setAge(hikerDTO.getAge());
		hikerDO.setPackageName(hikerDTO.getPackageName());
		hikerDO.setBookingDate(hikerDTO.getBookingDate());
		hikerDO.setHikerName(hikerDTO.getHikerName());
		hikerDO.setOtherHikerDetails(hikerDTO.getOtherHikersAge());
		hikerDO.setTotalSum(hikerDTO.getTotalSum());
		hikerRepository.save(hikerDO);
	}

	@Override
	public List<HikerDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
