package com.mindprove.zakat.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindprove.zakat.entities.PersonDetail;

public interface PersonDetailRepository extends JpaRepository<PersonDetail, Long> {

	Optional<PersonDetail> findByEmail(String email);
}
