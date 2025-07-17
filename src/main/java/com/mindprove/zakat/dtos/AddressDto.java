package com.mindprove.zakat.dtos;

import java.util.Date;

import lombok.Data;
@Data
public class AddressDto {

	private String street;
	private String city;
	private String state;
	private String country;
	private Integer zipCode;
	private Date createdAt;
	private Date updatedAt;
	private long personDetailId;

}
