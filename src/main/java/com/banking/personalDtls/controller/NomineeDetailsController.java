package com.banking.personalDtls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.personalDtls.entity.NomineeDetails;
import com.banking.personalDtls.service.NomineeDetailsService;

@RestController
@RequestMapping("/api/nominee")
public class NomineeDetailsController {

	@Autowired
	private NomineeDetailsService NomineeService;
	
	public List<NomineeDetails> getNomineesByScheme(@PathVariable Long schemeId)

	
	{
		return NomineeService.getNomineeByScheme(schemeId);
		
	}
}
