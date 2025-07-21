package com.mindprove.zakat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindprove.zakat.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
