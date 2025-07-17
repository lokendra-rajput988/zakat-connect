package com.mindprove.zakat.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindprove.zakat.dtos.AddressDto;
import com.mindprove.zakat.entities.Address;
import com.mindprove.zakat.exceptions.NotFoundException;
import com.mindprove.zakat.mapper.AddressMapper;
import com.mindprove.zakat.repositories.AddressRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;
	private final AddressMapper addressMapper;
	
	@Override
	public AddressDto createAddress(AddressDto addressDto) {
	    log.info("create address method called ");
		return addressMapper.toDTO(addressRepository.save(addressMapper.toEntity(addressDto)));
	}

	@Override
	public AddressDto updateAddressById(long id, AddressDto addressDto) {
		log.info("update address by id method called");
		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("address id " + id + " is not found", 404));
		address.setStreet(addressDto.getStreet());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setCountry(addressDto.getCountry());
		address.setZipCode(addressDto.getZipCode());
		Address address1=addressMapper.toEntity(addressDto);
		address.setPersonDetail(address1.getPersonDetail());
		return addressMapper.toDTO(addressRepository.save(address));
	}

	@Override
	public AddressDto getAddressById(long id) {
		log.info("get address by id method called");
		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("address id " + id + " is not found", 404));
		return addressMapper.toDTO(address);
	}

	@Override
	public boolean deleteAddressById(long id) {
		log.info("delete address by id method called");
		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("address id " + id + " is not found", 404));
		addressRepository.delete(address);
		log.info("delete address by id method completed");
		return true;
	}

	@Override
	public List<AddressDto> getAllAddress() {
		log.info("get all address method called");
		List<AddressDto> addressDtos=addressRepository.findAll().stream().map(addressMapper::toDTO).toList();
		log.info("get all address method completed");
		return addressDtos;
	}

}
