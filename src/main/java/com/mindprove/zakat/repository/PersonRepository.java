package com.mindprove.zakat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindprove.zakat.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Optional<Person> findByEmail(String email);
}
