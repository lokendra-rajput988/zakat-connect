package com.mindprove.zakat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindprove.zakat.dto.ResponseDTO;
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ResponseDTO> notFoundException(NotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(e.getMessage(), null, HttpStatus.NOT_FOUND));
	}
	
	@ExceptionHandler(AlreadyExistException.class)
	public ResponseEntity<ResponseDTO> alreadyExistException(AlreadyExistException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseDTO(e.getMessage(), null, HttpStatus.CONFLICT));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> exception(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(e.getMessage(), null, HttpStatus.BAD_REQUEST));
	}
}
