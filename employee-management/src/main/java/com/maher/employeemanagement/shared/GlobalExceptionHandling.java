package com.maher.employeemanagement.shared;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandling
{
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<GlobalErrorResponse<?>> handleNoResourceException(NoResourceFoundException ex)
	{
		List<GlobalErrorResponse.ErrorItem> errorItem = List.of(new GlobalErrorResponse.ErrorItem(ex.getStatusCode().value(), ex.getMessage()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GlobalErrorResponse<>(errorItem));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<GlobalErrorResponse<?>> handleNotValidException(MethodArgumentNotValidException ex)
	{
		var errorItem = ex.getBindingResult().getFieldErrors().stream()
				.map(err -> new GlobalErrorResponse.ErrorItem(err.getCodes() != null ? err.getCodes().length : 0, err.getField() + " " + err.getDefaultMessage())).toList();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GlobalErrorResponse<>(errorItem));
	}

	@ExceptionHandler(MyCustomException.class)
	public ResponseEntity<GlobalErrorResponse<?>> handleNotfoundInDB(MyCustomException customException)
	{
		List<GlobalErrorResponse.ErrorItem> errorItems = List.of(
				new GlobalErrorResponse.ErrorItem(customException.getCode(), customException.getMessage()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GlobalErrorResponse<>(errorItems));
	}
}
