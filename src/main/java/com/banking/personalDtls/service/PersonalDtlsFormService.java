package com.banking.personalDtls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.personalDtls.dto.PersonalDtlsFormDto;
import com.banking.personalDtls.entity.PersonalDtlsForm;
import com.banking.personalDtls.repository.PersonalDtlsFormRepository;

@Service
public class PersonalDtlsFormService {

	@Autowired
	private PersonalDtlsFormRepository personalRepository;
	
	public PersonalDtlsForm save(PersonalDtlsFormDto dto)
	{
		PersonalDtlsForm details  = new PersonalDtlsForm();
		details.setTitle(dto.getTitle());
		details.setFatherName(dto.getFatherName());
		details.setFirstname(dto.getFirstName());
		details.setMidname(dto.getMiddleName());
		details.setLastname(dto.getLastName());
		details.setDob(dto.getDob());
		details.setGender(dto.getGender());
		details.setMotherName(dto.getMotherName());
		details.setPan(dto.getPan());
		
		return personalRepository.save(details);
		
	}
}
