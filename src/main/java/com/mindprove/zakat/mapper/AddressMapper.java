package com.mindprove.zakat.mapper;

import org.springframework.stereotype.Component;

import com.mindprove.zakat.dtos.AddressDto;
import com.mindprove.zakat.entities.Address;
import com.mindprove.zakat.entities.PersonDetail;
import com.mindprove.zakat.exceptions.NotFoundException;
import com.mindprove.zakat.repositories.PersonDetailRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class AddressMapper {

	private final PersonDetailRepository personDetailRepository;

	public Address toEntity(AddressDto addressDto) {
		log.info("DTO to Entity mapper method got called");
		Address address = new Address();
		address.setStreet(addressDto.getStreet());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setCountry(addressDto.getCountry());
		address.setZipCode(addressDto.getZipCode());
		PersonDetail personDetail = personDetailRepository.findById(addressDto.getPersonDetailId()).orElseThrow(
				() -> new NotFoundException("person id " + addressDto.getPersonDetailId() + "is not found", 404));
		address.setPersonDetail(personDetail);
		return address;
	}

	public AddressDto toDTO(Address address) {
		log.info("Entity to DTO mapper method got called");
		AddressDto addressDto = new AddressDto();
		addressDto.setStreet(address.getStreet());
		addressDto.setCity(address.getCity());
		addressDto.setCountry(address.getCountry());
		addressDto.setState(address.getState());
		addressDto.setZipCode(address.getZipCode());
		addressDto.setCreatedAt(address.getCreatedAt());
		addressDto.setUpdatedAt(address.getUpdatedAt());
		addressDto.setPersonDetailId(address.getPersonDetail().getId());
		return addressDto;
	}
}
