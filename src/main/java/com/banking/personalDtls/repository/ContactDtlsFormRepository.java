package com.banking.personalDtls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.personalDtls.entity.ContactDtlsForm;

@Repository
public interface ContactDtlsFormRepository extends JpaRepository<ContactDtlsForm, Long> {
	

}
