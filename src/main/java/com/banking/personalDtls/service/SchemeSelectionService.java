package com.banking.personalDtls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.personalDtls.entity.PersonalDtlsForm;
import com.banking.personalDtls.entity.SchemeSelection;
import com.banking.personalDtls.repository.PersonalDtlsFormRepository;
import com.banking.personalDtls.repository.SchemeSelectionRepository;

@Service
public class SchemeSelectionService {

    @Autowired
    private SchemeSelectionRepository schemeRepository;

    @Autowired
    private PersonalDtlsFormRepository personalRepository;

    public SchemeSelection save(Long personalId, SchemeSelection form) {
        // ✅ 1. Fetch PersonalDetails by ID
        PersonalDtlsForm personal = personalRepository.findById(personalId)
                .orElseThrow(() -> new RuntimeException("Personal record not found with ID: " + personalId));

        // ✅ 2. Create new SchemeSelection and set properties
        SchemeSelection scheme = new SchemeSelection();
        scheme.setLifeCycleFund(form.getLifeCycleFund());
        scheme.setSchemeChoice(form.getSchemeChoice());

        // ✅ 3. Link SchemeSelection with PersonalDtlsForm
        scheme.setPersonalDetails(personal);

        // ✅ 4. (Optional) link back for bidirectional consistency
        personal.setSchemeSelection(scheme);

        // ✅ 5. Save and return
        return schemeRepository.save(scheme);
    }
}
