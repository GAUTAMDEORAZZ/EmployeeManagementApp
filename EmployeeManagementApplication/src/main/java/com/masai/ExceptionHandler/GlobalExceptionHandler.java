package com.masai.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.masai.Model.Employee;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<myErrorDetails> EmployeeExceptionHandler(EmployeeException ee, WebRequest req){
		myErrorDetails error=new myErrorDetails(ee.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<myErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<myErrorDetails> DepartmentExceptionHandler(DepartmentException de, WebRequest req){
		
		myErrorDetails error=new myErrorDetails(de.getMessage(),LocalDateTime.now(),req.getDescription(false));
		
		return new ResponseEntity<myErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<myErrorDetails> ValidationHandler(MethodArgumentNotValidException me){
		myErrorDetails error=new myErrorDetails("Validation Error",LocalDateTime.now(), me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<myErrorDetails>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<myErrorDetails> OtherExceptionHandler(Exception oe, WebRequest req){
		
		myErrorDetails error=new myErrorDetails(oe.getMessage(),LocalDateTime.now(),req.getDescription(false));
		
		return new ResponseEntity<myErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}

}

