package com.mindtree.filmapp.Exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<Object> handleApiException(InvalidDataException e)
	{
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		ApiException apiException=new ApiException(e.getMessage(), e, badRequest,
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		 return new ResponseEntity<>(apiException,badRequest);
	}
	
}
