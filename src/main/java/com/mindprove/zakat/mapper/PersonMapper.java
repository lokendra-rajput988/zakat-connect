package com.mindprove.zakat.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mindprove.zakat.dto.AddressDto;
import com.mindprove.zakat.dto.PersonDto;
import com.mindprove.zakat.entity.Address;
import com.mindprove.zakat.entity.Person;
import com.mindprove.zakat.entity.PersonRole;
import com.mindprove.zakat.entity.Role;
import com.mindprove.zakat.exception.NotFoundException;
import com.mindprove.zakat.repository.PersonRoleRepository;
import com.mindprove.zakat.repository.RoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class PersonMapper {

	private final PersonRoleRepository personRoleRepository;
	private final RoleRepository roleRepository;
	
	public Person toEntity(PersonDto personDto) {
		log.info("DTO to Entity mapper method got called ");
		Person person = new Person();
		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setEmail(personDto.getEmail());
		person.setPassword(personDto.getPassword());
		person.setAge(personDto.getAge());
		person.setGender(personDto.getGender());
		person.setMobile(personDto.getMobile());
		person.setActive(personDto.isActive());
		person.setDescription(personDto.getDescription());
		List<Address> addressList= new ArrayList<Address>();
		for(AddressDto addressDto : personDto.getAddress()) {
		    Address address = new Address();
			address.setStreet(addressDto.getStreet());
			address.setCity(addressDto.getCity());
			address.setState(addressDto.getState());
			address.setCountry(addressDto.getCountry());
			address.setZipCode(addressDto.getZipCode());
			addressList.add(address);
		
		}	
		person.setAddress(addressList);
		List<PersonRole> personRoles = new ArrayList<>();
		for(long roleId : personDto.getRoleIds()) {
			PersonRole personRole = new PersonRole();
			Role role =roleRepository.findById(roleId).orElseThrow(() -> new NotFoundException("role id "+ roleId+" is not found", 404));
			personRole.setRole(role);
			personRoles.add(personRole);
			personRoleRepository.save(personRole);
		}
		person.setPersonRoles(personRoles);
		log.info("DTO to Entity mapper method completed ");
		return person;
	}

	public PersonDto toDTO(Person person) {
		log.info("Entity To DTO mapper method got called");
		PersonDto personDto = new PersonDto();
		personDto.setFirstName(person.getFirstName());
		personDto.setLastName(person.getLastName());
		personDto.setEmail(person.getEmail());
		personDto.setPassword(person.getPassword());
		personDto.setMobile(person.getMobile());
		personDto.setGender(person.getGender());
		personDto.setAge(person.getAge());
		personDto.setActive(person.isActive());
		personDto.setDescription(person.getDescription());
		
		List<AddressDto> addressDtos= new ArrayList<>();
		for(Address address : person.getAddress()) {
			AddressDto addressDto = new AddressDto();
			addressDto.setStreet(address.getStreet());
			addressDto.setCity(address.getCity());
			addressDto.setState(address.getState());
			addressDto.setCountry(address.getCountry());
			addressDto.setZipCode(address.getZipCode());
			addressDtos.add(addressDto);
		}
		personDto.setAddress(addressDtos);
		List<Long> roleIds = new ArrayList<>();
		for(PersonRole personRole : person.getPersonRoles()) {
			long roleId =personRole.getRole().getId();
			roleIds.add(roleId);
		}
		personDto.setRoleIds(roleIds);
		log.info("Entity To DTO mapper method completed");
		return personDto;
	}

}
