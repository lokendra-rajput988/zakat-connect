package com.mindprove.zakat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindprove.zakat.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
