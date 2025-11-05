package com.banking.personalDtls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.personalDtls.entity.UploadDocuments;
import com.banking.personalDtls.service.UploadDocumentsService;

@RestController
@RequestMapping("/api/documents")
public class UploadDocumentsController {
	
	@Autowired
	private UploadDocumentsService uploadService;
	
	
	@PostMapping("/upload/{PersonalId}")
	public ResponseEntity<UploadDocuments> savePhotoSignature(@PathVariable Long PersonalId, @RequestBody UploadDocuments upload)
	{
		
		UploadDocuments documents = uploadService.savePhotoSignature(PersonalId, upload);
		
		return ResponseEntity.ok(documents);
		
	}

}
