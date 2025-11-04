package com.banking.personalDtls.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.personalDtls.entity.NomineeDetails;
import com.banking.personalDtls.entity.SchemeSelection;
import com.banking.personalDtls.repository.SchemeSelectionRepository;

@Service
public class SchemeSelectionService {

    @Autowired
    private SchemeSelectionRepository schemeRepository;

    // ✅ Save scheme with nominee details
    public SchemeSelection saveScheme(SchemeSelection form) {

        SchemeSelection scheme = new SchemeSelection();
        scheme.setSchemeChoice(form.getSchemeChoice());
        scheme.setLifeCycleFund(form.getLifeCycleFund());

       
        List<NomineeDetails> nomineeList = new ArrayList<>();
        if (form.getNomineeDetails() != null) {
            for (NomineeDetails n : form.getNomineeDetails()) {
                NomineeDetails nominee = new NomineeDetails();
                nominee.setFirstName(n.getFirstName());
                nominee.setLastName(n.getLastName());
                nominee.setRelationship(n.getRelationship());
                nominee.setDateOfBirth(n.getDateOfBirth());
                nominee.setPercentage(n.getPercentage());
                nominee.setMinorNominee(n.getMinorNominee());
                nominee.setGuardianName(n.getGuardianName());
                nominee.setGuardianRelationship(n.getGuardianRelationship());
                nominee.setSchemeSelection(scheme); // link relation
                nomineeList.add(nominee);
            }
        }

        scheme.setNomineeDetails(nomineeList);

        return schemeRepository.save(scheme);
    }

    // ✅ Get scheme by ID
    public SchemeSelection getSchemeById(long id) {
        SchemeSelection scheme = schemeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scheme not found with ID: " + id));
        
        List<NomineeDetails> nominee = scheme.getNomineeDetails().stream().map(n -> 
        {
        	NomineeDetails form = new NomineeDetails();
        	form.setFirstName(n.getFirstName());
        	form.setLastName(n.getLastName());
        	form.setDateOfBirth(n.getDateOfBirth());
        	form.setPercentage(n.getPercentage());
        	form.setGuardianName(n.getGuardianName());
        	form.setMinorNominee(n.getMinorNominee());
        	form.setRelationship(n.getRelationship());
        	form.setGuardianRelationship(n.getGuardianRelationship());
        	return form;
        })
        		 .collect(Collectors.toList());
        SchemeSelection result = new SchemeSelection();
        result.setId(scheme.getId());
        result.setSchemeChoice(scheme.getSchemeChoice());
        result.setLifeCycleFund(scheme.getLifeCycleFund());
        result.setNomineeDetails(nominee);

        return result;
       
    }
    

 // ✅ Get all schemes
    public List<SchemeSelection> getAllSchemes() {
        return schemeRepository.findAll().stream()
                .map(s -> {
                    SchemeSelection form = new SchemeSelection();
                    form.setId(s.getId());
                    form.setSchemeChoice(s.getSchemeChoice());
                    form.setLifeCycleFund(s.getLifeCycleFund());

                    // Map NomineeDetails list
                    List<NomineeDetails> nomineeList = s.getNomineeDetails().stream()
                            .map(n -> {
                                NomineeDetails nominee = new NomineeDetails();
                                nominee.setId(n.getId());
                                nominee.setFirstName(n.getFirstName());
                                nominee.setLastName(n.getLastName());
                                nominee.setDateOfBirth(n.getDateOfBirth());
                                nominee.setGuardianName(n.getGuardianName());
                                nominee.setGuardianRelationship(n.getGuardianRelationship());
                                nominee.setPercentage(n.getPercentage());
                                nominee.setMinorNominee(n.getMinorNominee());
                                nominee.setRelationship(n.getRelationship());
                                return nominee;
                            })
                            .collect(Collectors.toList());

                    form.setNomineeDetails(nomineeList);
                    return form;
                })
                .collect(Collectors.toList());
    }

    // ✅ Delete scheme
    public void deleteScheme(long id) {
        if (!schemeRepository.existsById(id)) {
            throw new RuntimeException("Scheme not found with ID: " + id);
        }
        schemeRepository.deleteById(id);
    }
}
