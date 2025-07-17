package com.mindprove.zakat.services;

import java.util.List;

import com.mindprove.zakat.dtos.AddressDto;

public interface AddressService {

	AddressDto createAddress(AddressDto addressDto);
	AddressDto updateAddressById(long id,AddressDto addressDto);
	AddressDto getAddressById(long id);
	boolean deleteAddressById(long id);
	List<AddressDto> getAllAddress();
}
