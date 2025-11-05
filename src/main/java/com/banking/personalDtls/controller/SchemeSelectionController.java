package com.banking.personalDtls.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.personalDtls.entity.SchemeSelection;
import com.banking.personalDtls.service.SchemeSelectionService;

@RestController
@RequestMapping("/api/scheme")
public class SchemeSelectionController {
	
	@Autowired
	private SchemeSelectionService schemeService;
	
	@PostMapping("/{personalId}")
	public ResponseEntity<SchemeSelection> save(@PathVariable Long personalId, @RequestBody SchemeSelection form )
	{
		SchemeSelection scheme = schemeService.save(personalId, form);
		return ResponseEntity.ok(scheme);
	}
	

}
