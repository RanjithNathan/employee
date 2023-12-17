package com.Employee.EmployeeDetails.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@RestController
public class CustomizedExceptionResponseHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex,WebRequest req)
	{
		ExceptionResponse exresponse=new ExceptionResponse(new Date(),ex.getMessage(),req.getDescription(false));
		return new ResponseEntity(exresponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler(com.Employee.EmployeeDetails.Exception.UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,WebRequest req)
	{
		ExceptionResponse exresponse=new ExceptionResponse(new Date(),ex.getMessage(),req.getDescription(false));
		return new ResponseEntity(exresponse,HttpStatus.NOT_FOUND);
		
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exresponse=new ExceptionResponse(new Date(),"validation Failed",ex.getBindingResult().toString());
		
		return new ResponseEntity(exresponse, HttpStatus.BAD_REQUEST);
	}

}
