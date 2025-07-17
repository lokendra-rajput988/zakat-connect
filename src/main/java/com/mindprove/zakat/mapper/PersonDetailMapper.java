package com.mindprove.zakat.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.mindprove.zakat.controllers.PersonDetailController;
import com.mindprove.zakat.dtos.PersonDetailDto;
import com.mindprove.zakat.entities.Address;
import com.mindprove.zakat.entities.PersonDetail;
import com.mindprove.zakat.exceptions.NotFoundException;
import com.mindprove.zakat.repositories.AddressRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class PersonDetailMapper {

	private final AddressRepository addressRepository;

	public PersonDetail toEntity(PersonDetailDto personDetailDto) {
		log.info("DTO to Entity mapper method got called ");
		PersonDetail personDetail = new PersonDetail();
		personDetail.setFirstName(personDetailDto.getFirstName());
		personDetail.setLastName(personDetailDto.getLastName());
		personDetail.setEmail(personDetailDto.getEmail());
		personDetail.setPassword(personDetailDto.getPassword());
		personDetail.setConfirmPassword(personDetailDto.getConfirmPassword());
		personDetail.setAge(personDetailDto.getAge());
		personDetail.setGender(personDetailDto.getGender());
		personDetail.setMobile(personDetailDto.getMobile());
		personDetail.setActive(personDetailDto.isActive());
		personDetail.setDescription(personDetailDto.getDescription());

		List<Address> addressList = new ArrayList<>();
		for (Long addressId : personDetailDto.getAddressId()) {
			Address address = addressRepository.findById(addressId)
					.orElseThrow(() -> new NotFoundException("address id " + addressId + "is not found", 404));
			addressList.add(address);

		}
		personDetail.setAddress(addressList);
		return personDetail;
	}

	public PersonDetailDto toDTO(PersonDetail personDetail) {
		log.info("Entity To DTO mapper method got called");
		PersonDetailDto personDetailDto = new PersonDetailDto();
		personDetailDto.setFirstName(personDetail.getFirstName());
		personDetailDto.setLastName(personDetail.getLastName());
		personDetailDto.setEmail(personDetail.getEmail());
		personDetailDto.setPassword(personDetail.getPassword());
		personDetailDto.setConfirmPassword(personDetail.getConfirmPassword());
		personDetailDto.setMobile(personDetail.getMobile());
		personDetailDto.setGender(personDetail.getGender());
		personDetailDto.setAge(personDetail.getAge());
		personDetailDto.setActive(personDetail.isActive());
		personDetailDto.setDescription(personDetail.getDescription());
		personDetailDto.setCreatedAt(personDetail.getCreatedAt());
		personDetailDto.setUpdatedAt(personDetail.getUpdatedAt());

		List<Long> addressIds = new ArrayList<Long>();
		for (Address address : personDetail.getAddress()) {
			addressIds.add(address.getId());
		}
		personDetailDto.setAddressId(addressIds);
		return personDetailDto;
	}

}
