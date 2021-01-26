package com.elements.controller;





import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elements.DO.HikerDO;
import com.elements.controller.mapper.HikerHelperService;
import com.elements.dto.HikerDTO;
import com.elements.exception.ConstraintsViolationException;
import com.elements.exception.EntityNotFoundException;
import com.elements.service.ifc.HikerService;

@RestController
@RequestMapping("hiker")
@Secured("HIKER")
@Validated
public class HikerController {
	private final HikerService hikerService;
	private final HikerHelperService hikerMapper;

    @Autowired
    public HikerController(final HikerService hikerService, final HikerHelperService hikerMapper)
    {
        this.hikerService = hikerService;
        this.hikerMapper = hikerMapper;
    }
	
    @GetMapping("/{hikerId}")
    //@PreAuthorize("hasRole('HIKER')")
    public HikerDTO getHiker(@Valid @PathVariable long hikerId) throws EntityNotFoundException
    {
        return hikerMapper.makeHikerDTO(hikerService.find(hikerId));
    }
    
    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HikerDTO createHiker(@Valid @RequestBody HikerDTO hikerDTO) throws ConstraintsViolationException, EntityNotFoundException 
    {
        HikerDO hikerDO = hikerMapper.makeHikerDO(hikerDTO);
        return hikerMapper.makeHikerDTO(hikerService.create(hikerDO));
    }
    
    @DeleteMapping("/{hikerId}")
    public void deleteCar(@Valid @PathVariable long hikerId) throws EntityNotFoundException
    {
    	hikerService.delete(hikerId);
    }
    
    @PutMapping("/{hikerId}")
    public void updateRating(
        @Valid @PathVariable long carId, @RequestParam HikerDTO hikerDTO)
        throws  EntityNotFoundException
    {
        hikerService.update(hikerDTO);
    }
    
    
}
