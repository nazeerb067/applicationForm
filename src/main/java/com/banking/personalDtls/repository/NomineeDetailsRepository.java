package com.banking.personalDtls.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.personalDtls.entity.NomineeDetails;

public interface NomineeDetailsRepository extends JpaRepository<NomineeDetails, Long>{

	List<NomineeDetails> findBySchemeSelectionId(Long schemeId);
	
	
	
	

}
