package com.banking.personalDtls.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Builder
@Table(name = "schemeSeclection")
public class SchemeSelection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String schemeChoice;
	private String lifeCycleFund;
	
	@OneToOne
	@JoinColumn(name = "personal_Id")
	private PersonalDtlsForm personalDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public String getSchemeChoice() {
		return schemeChoice;
	}

	public void setSchemeChoice(String schemeChoice) {
		this.schemeChoice = schemeChoice;
	}

	public String getLifeCycleFund() {
		return lifeCycleFund;
	}

	public void setLifeCycleFund(String lifeCycleFund) {
		this.lifeCycleFund = lifeCycleFund;
	}

	public PersonalDtlsForm getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDtlsForm personalDetails) {
		this.personalDetails = personalDetails;
	}

	public SchemeSelection(Long id, String schemeChoice, String lifeCycleFund, PersonalDtlsForm personalDetails) {
		super();
		id = id;
		this.schemeChoice = schemeChoice;
		this.lifeCycleFund = lifeCycleFund;
		this.personalDetails = personalDetails;
	}

	public SchemeSelection() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SchemeSelection [Id=" + id + ", schemeChoice=" + schemeChoice + ", lifeCycleFund=" + lifeCycleFund
				+ ", personalDetails=" + personalDetails + "]";
	}
	
	
	

}
