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

@Entity
@Table(name = "schemeSeclection")
public class SchemeSelection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long Id;
	private String schemeChoice;
	private String lifeCycleFund;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getSchemeChoice() {
		return schemeChoice;
	}
	public void setSchemeChoice(String schemeChoice) {
		this.schemeChoice = schemeChoice;
	}
	public List<NomineeDetails> getNomineeDetails() {
		return nomineeDetails;
	}
	public void setNomineeDetails(List<NomineeDetails> nomineeDetails) {
		this.nomineeDetails = nomineeDetails;
	}
	public String getLifeCycleFund() {
		return lifeCycleFund;
	}
	public void setLifeCycleFund(String lifeCycleFund) {
		this.lifeCycleFund = lifeCycleFund;
	}
	
	@OneToOne
	@JoinColumn(name = "personal_Id")
	private PersonalDtlsForm personalDetails;
	
	 @OneToMany(mappedBy = "schemeSelection", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<NomineeDetails> nomineeDetails = new ArrayList<>();
	

}
