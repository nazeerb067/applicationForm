package com.banking.personalDtls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banking.personalDtls.entity.ContactDtlsForm;
import com.banking.personalDtls.service.ContactDtlsFormService;
import com.banking.personalDtls.service.PersonalDtlsFormService;

@RestController
@RequestMapping("/api/contact")
public class ContactDtlsFormController {

    @Autowired
    private PersonalDtlsFormService personalService;

    @Autowired
    private ContactDtlsFormService contactService; // fixed variable name

    // ✅ Add correct annotations and method signature
    @PostMapping("/save/{personalId}")
    public ResponseEntity<ContactDtlsForm> save(
            @PathVariable Long personalId,
            @RequestBody ContactDtlsForm form) {

        ContactDtlsForm details = contactService.save(personalId, form);
        return ResponseEntity.ok(details);
    }
}
