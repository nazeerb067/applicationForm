package com.banking.personalDtls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.personalDtls.entity.BankDetails;
import com.banking.personalDtls.service.BankDetailsService;

@RestController
@RequestMapping("/api/bank")

public class BankDetailsController {
	 @Autowired
	    private BankDetailsService bankService;

	    @PostMapping("/save/{personalId}")
	    public ResponseEntity<BankDetails> saveBankDetails(
	            @PathVariable Long personalId,
	            @RequestBody BankDetails form) {

	        BankDetails saved = bankService.save(personalId, form);
	        return ResponseEntity.ok(saved);
	    }

}
