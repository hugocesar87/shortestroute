package com.exercise.shortestroute.commons.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exercise.shortestroute.commons.config.ApplicationExceptionProperties;
import com.exercise.shortestroute.web.dto.commons.ResponseDto;

@ControllerAdvice
public class ShortestRouteExceptionHandler extends ResponseEntityExceptionHandler {
	
	private final Logger log = LoggerFactory.getLogger(ShortestRouteExceptionHandler.class);
	private static final String DEFAULT_EXCEPTION_CODE = "SHORTEST_ROUTE_ERROR_101";
	private static final String VALIDATION_EXCEPTION_CODE = "SHORTEST_ROUTE_ERROR_102";
	
	private ApplicationExceptionProperties applicationExceptionProperties;

	public ShortestRouteExceptionHandler(ApplicationExceptionProperties applicationExceptionProperties) {
		super();
		this.applicationExceptionProperties = applicationExceptionProperties;
	}
	
	@Override
	public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, String> errors = new HashMap<>();
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			errors.put(((FieldError) error).getField(),error.getDefaultMessage());
		}
		ResponseDto<Object> exceptionDetailsDto = new ResponseDto<>(ResponseDto.ERROR,
				VALIDATION_EXCEPTION_CODE, applicationExceptionProperties.getException().get(VALIDATION_EXCEPTION_CODE), errors);
		return new ResponseEntity<>(exceptionDetailsDto, HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(ConstraintViolationException.class)
	 @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	 public ResponseEntity<ResponseDto<List<String>>> handleResourceNotFoundException(ConstraintViolationException e) {
	      Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
	      List<String> messages = new ArrayList<String>();
	      for (ConstraintViolation<?> violation : violations ) {
	           messages.add(violation.getMessage());
	      }
	      ResponseDto<List<String>> exceptionDetailsDto = new ResponseDto<>(ResponseDto.ERROR,
					VALIDATION_EXCEPTION_CODE, applicationExceptionProperties.getException().get(VALIDATION_EXCEPTION_CODE), messages);
	      return new ResponseEntity<>(exceptionDetailsDto, HttpStatus.BAD_REQUEST);
	 }
	
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<ResponseDto<?>> handleUserBadRequests(BadRequestException ex) {
		
		log.error("BadRequestException was thrown: " + ex);
		ResponseDto<Object> exceptionDetailsDto = new ResponseDto<>(ResponseDto.ERROR,
				ex.getExceptionCode(), applicationExceptionProperties.getException().get(ex.getExceptionCode()), null);
		return new ResponseEntity<>(exceptionDetailsDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseDto<?>> handleGeneralException(Exception ex) {

		log.error("An Exception was thrown: " + ex);
		ResponseDto<Object> exceptionDetailsDto = new ResponseDto<>(ResponseDto.ERROR,
				DEFAULT_EXCEPTION_CODE, applicationExceptionProperties.getException().get(DEFAULT_EXCEPTION_CODE), null);
		return new ResponseEntity<>(exceptionDetailsDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
