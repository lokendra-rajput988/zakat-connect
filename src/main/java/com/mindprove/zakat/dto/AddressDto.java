package com.mindprove.zakat.dto;

import lombok.Data;

@Data
public class AddressDto {

	private String street;
	private String city;
	private String state;
	private String country;
	private Integer zipCode;
}
