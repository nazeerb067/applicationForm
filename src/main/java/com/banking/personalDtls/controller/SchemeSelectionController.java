package com.banking.personalDtls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@PostMapping("/save")
	public ResponseEntity<SchemeSelection> saveScheme(@RequestBody SchemeSelection form  )
	{
		SchemeSelection saved = schemeService.saveScheme(form);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("/{Id}")
	public SchemeSelection getScheme(@PathVariable  Long Id)
	{
		return schemeService.getSchemeById(Id);
		
	}
	
	@GetMapping("/All")
	public List<SchemeSelection >getAllSchemes()
	{
		return schemeService.getAllSchemes();
	}
	

}
