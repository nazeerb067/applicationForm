package com.banking.personalDtls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.personalDtls.entity.BankDetails;


@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {

}
