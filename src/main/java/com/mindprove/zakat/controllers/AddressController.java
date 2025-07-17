package com.mindprove.zakat.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindprove.zakat.dtos.AddressDto;
import com.mindprove.zakat.response.ResponseDTO;
import com.mindprove.zakat.services.AddressService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/address/")
public class AddressController {

	private final AddressService addressService;
	
	@PostMapping("createAddress")
	public ResponseEntity<ResponseDTO> createAddress(@RequestBody AddressDto addressDto){
		log.info("Post API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", addressService.createAddress(addressDto), HttpStatus.CREATED));
	}
	
	@PatchMapping("updateAddress/{id}")
	public ResponseEntity<ResponseDTO> updateAddressById(@PathVariable long id,@RequestBody AddressDto addressDto){
		log.info("Patch API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", addressService.updateAddressById(id, addressDto), HttpStatus.OK));
	}
	
	@GetMapping("getAddressById/{id}")
	public ResponseEntity<ResponseDTO> getAddressById(@PathVariable long id){
		log.info("Get API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", addressService.getAddressById(id), HttpStatus.OK));
	} 
	
	@GetMapping("getAllAddress")
	public ResponseEntity<ResponseDTO> getAllAddress(){
		log.info("Get API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", addressService.getAllAddress(), HttpStatus.OK));
	} 
	
	@DeleteMapping("deleteAddressById/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressById(@PathVariable long id){
		log.info("Delete API method called");
		return ResponseEntity.ok().body(new ResponseDTO("Success", addressService.deleteAddressById(id), HttpStatus.OK));
	} 
	
	
}
