package com.banking.personalDtls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.personalDtls.entity.ContactDtlsForm;
import com.banking.personalDtls.entity.PersonalDtlsForm;
import com.banking.personalDtls.repository.ContactDtlsFormRepository;
import com.banking.personalDtls.repository.PersonalDtlsFormRepository;

@Service
public class ContactDtlsFormService {
	
	@Autowired
	private ContactDtlsFormRepository ContactRepository;

	@Autowired
	private PersonalDtlsFormRepository personalRepository;
	
	public ContactDtlsForm save( Long personalId, ContactDtlsForm form)
	{
		PersonalDtlsForm personal = personalRepository.findById(personalId).orElseThrow(()-> new RuntimeException(" personal Details not found with ID:"+ personalId));
		
		ContactDtlsForm contact = new ContactDtlsForm();
		contact.setEmail(form.getEmail());
		contact.setMobileNumber(form.getMobileNumber());
		contact.setAddress1(form.getAddress1());
		contact.setAddress2(form.getAddress2());
		contact.setCity(form.getCity());
		contact.setCountry(form.getCountry());
		contact.setPincode(form.getPincode());
		contact.setCitizentype(form.getCitizentype());
		contact.setPersonalDetails(personal);
		contact.setState(form.getState());
		
		
		return ContactRepository.save(contact);
	}

}
