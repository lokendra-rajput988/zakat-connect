package com.mindprove.zakat.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseDTO {

	private String message;
	private Object object;
	private HttpStatus httpStatus;
	private LocalDateTime localDateTime;
	
	public ResponseDTO(String message,Object object,HttpStatus httpStatus) {
		this.message=message;
		this.object=object;
		this.httpStatus=httpStatus;
		this.localDateTime=LocalDateTime.now();
	}
}
