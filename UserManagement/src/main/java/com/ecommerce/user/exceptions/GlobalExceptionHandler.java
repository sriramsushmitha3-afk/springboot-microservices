package com.ecommerce.user.exceptions;

import java.net.http.HttpResponse;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
		String path = request.getDescription(false).replace("uri=", "");
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), path);
//		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(errorResponse);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex, WebRequest request){
		
		
		String path = request.getDescription(false).replace("uri=", "");	

	
		String errorMessage = ex.getBindingResult()
								.getFieldErrors()
								.stream()
								.map(error->error.getField()+" : "+error.getDefaultMessage())
								.collect(Collectors.joining(", "));
		

		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.getReasonPhrase(),
				errorMessage,
				path);		
//		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								.body(errorResponse);
		
	}
}
