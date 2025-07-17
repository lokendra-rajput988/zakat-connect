package com.mindprove.zakat.mapper;

import org.springframework.stereotype.Component;

import com.mindprove.zakat.dtos.PersonDetailDto;
import com.mindprove.zakat.entities.PersonDetail;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PersonDetailMapper {
	
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
		return personDetailDto;
	}

}
