package com.banking.personalDtls.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.personalDtls.entity.NomineeDetails;
import com.banking.personalDtls.entity.PersonalDtlsForm;
import com.banking.personalDtls.entity.SchemeSelection;
import com.banking.personalDtls.repository.NomineeDetailsRepository;
import com.banking.personalDtls.repository.PersonalDtlsFormRepository;
import com.banking.personalDtls.repository.SchemeSelectionRepository;

@Service
public class NomineeDetailsService {

    @Autowired
    private PersonalDtlsFormRepository personalRepository;
    
    @Autowired
    private SchemeSelectionRepository schemeRepository;

    @Autowired
    private NomineeDetailsRepository nomineeRepository;

    public String addNominee(Long personalId,Long schemeSelectionId, NomineeDetails nominee) {
        // Fetch personal record
        PersonalDtlsForm personal = personalRepository.findById(personalId)
                .orElseThrow(() -> new RuntimeException("Personal record not found with ID: " + personalId));
        // Fetch scheme record
        SchemeSelection scheme = schemeRepository.findById(schemeSelectionId)
                .orElseThrow(() -> new RuntimeException("Scheme not found with ID: " + schemeSelectionId));

        // Link nominee to personal details
        nominee.setPersonalDtlsForm(personal);
        nominee.setSchemeSelection(scheme);

        // Save the nominee
        nomineeRepository.save(nominee);

        // Optional: add to list for bidirectional link
        if (personal.getNominees() == null) {
            personal.setNominees(new ArrayList<>());
        }
        personal.getNominees().add(nominee);
        personalRepository.save(personal);

        return "Nominee added successfully for Personal ID: " + personalId;
    }
}
