package com.banking.personalDtls.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity

@Table(name="bankDetails")
public class BankDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String accountType;
	private String accountNumber;
	private String ifscCode;
	private String bankName;
	private Boolean isUsPerson;
	private String 	countryOfTaxResidency;
	private String taxIdNumber;
	
	@OneToOne
	@JoinColumn(name = "personal_Id")
	private PersonalDtlsForm personalDetails;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Boolean getIsUsPerson() {
		return isUsPerson;
	}

	public void setIsUsPerson(Boolean isUsPerson) {
		this.isUsPerson = isUsPerson;
	}

	public String getCountryOfTaxResidency() {
		return countryOfTaxResidency;
	}

	public void setCountryOfTaxResidency(String countryOfTaxResidency) {
		this.countryOfTaxResidency = countryOfTaxResidency;
	}

	public String getTaxIDNumber() {
		return taxIdNumber;
	}

	public void setTaxIDNumber(String taxIDNumber) {
		this.taxIdNumber = taxIDNumber;
	}

	public PersonalDtlsForm getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDtlsForm personalDetails) {
		this.personalDetails = personalDetails;
	}

	

}
