package com.banking.personalDtls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.personalDtls.entity.BankDetails;
import com.banking.personalDtls.entity.PersonalDtlsForm;
import com.banking.personalDtls.repository.BankDetailsRepository;
import com.banking.personalDtls.repository.PersonalDtlsFormRepository;

@Service
public class BankDetailsService {

    @Autowired
    private PersonalDtlsFormRepository personalRepository;

    @Autowired
    private BankDetailsRepository bankRepository;

    public BankDetails save(Long personalId, BankDetails form) {
        // ✅ Correct repository used
        PersonalDtlsForm personal = personalRepository.findById(personalId)
                .orElseThrow(() -> new RuntimeException("Personal details not found for ID: " + personalId));

        // ✅ Map values from form
        BankDetails bank = new BankDetails();
        bank.setAccountType(form.getAccountType());
        bank.setAccountNumber(form.getAccountNumber());
        bank.setBankName(form.getBankName());
        bank.setIfscCode(form.getIfscCode());
        bank.setIsUsPerson(form.getIsUsPerson());
        bank.setTaxIDNumber(form.getTaxIDNumber());
        bank.setCountryOfTaxResidency(form.getCountryOfTaxResidency());
        bank.setPersonalDetails(personal);

        // ✅ Save and return
        return bankRepository.save(bank);
    }
}
