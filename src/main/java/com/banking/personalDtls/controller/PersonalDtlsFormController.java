package com.banking.personalDtls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.personalDtls.dto.PersonalDtlsFormDto;
import com.banking.personalDtls.entity.PersonalDtlsForm;
import com.banking.personalDtls.service.PersonalDtlsFormService;

@RestController
@RequestMapping("/api/personal-details")
public class PersonalDtlsFormController {
	
	@Autowired
	private PersonalDtlsFormService personalService;
	
	@PostMapping("/save")
	public ResponseEntity<PersonalDtlsForm>  saveDetails(@RequestBody PersonalDtlsFormDto dto)
	{
		PersonalDtlsForm saved = personalService.save(dto);
		return ResponseEntity.ok(saved);
		
	}
}
