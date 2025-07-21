package com.mindprove.zakat.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.mindprove.zakat.dto.PersonDto;
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
		log.info("person dto : {}"+personDto);
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
		person.setAddress(personDto.getAddress());
		List<PersonRole> personRoles = new ArrayList<>();
		for(long roleId : personDto.getRoleIds()) {
			PersonRole personRole = new PersonRole();
			Role role =roleRepository.findById(roleId).orElseThrow(() -> new NotFoundException("role id "+ roleId+" is not found", 404));
			personRole.setRole(role);
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
		personDto.setAddress(person.getAddress());
		List<Long> roleIds = new ArrayList<>();
		for(PersonRole personRole : person.getPersonRoles()) {
			long roleId =personRole.getRole().getId();
			System.out.println("roleId : "+roleId);
			roleIds.add(roleId);
		}
		personDto.setRoleIds(roleIds);
		log.info("Entity To DTO mapper method completed");
		return personDto;
	}

}
