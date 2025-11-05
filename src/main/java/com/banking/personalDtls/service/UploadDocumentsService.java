package com.banking.personalDtls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.personalDtls.entity.PersonalDtlsForm;
import com.banking.personalDtls.entity.UploadDocuments;
import com.banking.personalDtls.repository.PersonalDtlsFormRepository;
import com.banking.personalDtls.repository.UploadDocumentsRepository;

@Service
public class UploadDocumentsService {

	@Autowired
	private PersonalDtlsFormRepository personalRepository;


	
	@Autowired
	private UploadDocumentsRepository uploadRepository;
	
	
	
	public UploadDocuments  savePhotoSignature(Long personalId, UploadDocuments form )
	
	{
		 PersonalDtlsForm personal = personalRepository.findById(personalId)
	                .orElseThrow(() -> new RuntimeException("Personal record not found with ID: " + personalId));
		 
		UploadDocuments documents = new UploadDocuments();
		documents.setPhotoFileData(form.getPhotoFileData());
		documents.setSignatureFileData(form.getSignatureFileData());
		documents.setSubscriberDeclaration(form.getSubscriberDeclaration());
		documents.setPersonalDetails(personal);
		
		return uploadRepository.save(documents);
	}
}
