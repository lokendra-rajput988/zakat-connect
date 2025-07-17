package com.mindprove.zakat.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindprove.zakat.exceptions.APIHandlerException;
import com.mindprove.zakat.exceptions.NotFoundException;
import com.mindprove.zakat.response.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(APIHandlerException.class)
	public ResponseEntity<ResponseDTO> apiHandlerException(APIHandlerException e){
		log.info("APIHandlerException method got called");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ResponseDTO> notFoundException(NotFoundException e){
		log.info("NotFoundException method got called");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(e.getMessage(), null, HttpStatus.NOT_FOUND));
	}
}
