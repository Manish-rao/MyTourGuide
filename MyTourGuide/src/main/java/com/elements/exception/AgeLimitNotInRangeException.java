package com.elements.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Age limit exceeded")
public class AgeLimitNotInRangeException extends RuntimeException {

	static final long serialVersionUID = -3387516993334229948L;


    public AgeLimitNotInRangeException(String message)
    {    	
        super(message);
    }
}
