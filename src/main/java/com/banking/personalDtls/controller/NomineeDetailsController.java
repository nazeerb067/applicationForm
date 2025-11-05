package com.banking.personalDtls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.personalDtls.entity.NomineeDetails;
import com.banking.personalDtls.service.NomineeDetailsService;

@RestController
@RequestMapping("/api/nominee")
public class NomineeDetailsController {

	@Autowired
	private NomineeDetailsService nomineeService;
	
	@PostMapping("/add/{personalId}/{schemeSelectionId}")
	public ResponseEntity<String> addNominee(
	        @PathVariable Long personalId, @PathVariable Long schemeSelectionId,
	        @RequestBody NomineeDetails nominee) {

	    String message = nomineeService.addNominee(personalId, schemeSelectionId,nominee);
	    return ResponseEntity.ok(message);
	}

}
