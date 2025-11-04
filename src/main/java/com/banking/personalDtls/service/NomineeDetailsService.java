package com.banking.personalDtls.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.personalDtls.entity.NomineeDetails;
import com.banking.personalDtls.repository.NomineeDetailsRepository;

@Service
public class NomineeDetailsService {

    @Autowired
    private NomineeDetailsRepository nomineeRepository;

    public List<NomineeDetails> getNomineeByScheme(Long schemeId) {
        return nomineeRepository.findBySchemeSelectionId(schemeId)
                .stream()
                .map(n -> {
                    NomineeDetails form = new NomineeDetails();
                    form.setId(n.getId());
                    form.setFirstName(n.getFirstName());
                    form.setLastName(n.getLastName());
                    form.setDateOfBirth(n.getDateOfBirth());
                    form.setGuardianName(n.getGuardianName());
                    form.setGuardianRelationship(n.getGuardianRelationship());
                    form.setMinorNominee(n.getMinorNominee());
                    form.setPercentage(n.getPercentage());
                    form.setRelationship(n.getRelationship());
                    return form; // ✅ Must return the new object
                })
                .collect(Collectors.toList());
    }
}
