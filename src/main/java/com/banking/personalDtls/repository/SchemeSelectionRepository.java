package com.banking.personalDtls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.personalDtls.entity.SchemeSelection;


@Repository
public interface SchemeSelectionRepository  extends JpaRepository<SchemeSelection, Long>{
	

}
