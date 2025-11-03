package com.banking.personalDtls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.personalDtls.entity.PersonalDtlsForm;


@Repository
public interface PersonalDtlsFormRepository extends JpaRepository<PersonalDtlsForm, Long> {
	

}
