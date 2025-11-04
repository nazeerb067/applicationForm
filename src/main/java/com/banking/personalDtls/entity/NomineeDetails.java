package com.banking.personalDtls.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "NomineeDetails")
public class NomineeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long Id;
	private String firstName;
	private String LastName;
	private String Relationship;
	private LocalDate DateOfBirth;
	private Double Percentage;
	private Boolean minorNominee;
	private String guardianName;
	private String guardianRelationship;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheme_selection_id")
    @ToString.Exclude
    private SchemeSelection schemeSelection;

	@OneToOne
	@JoinColumn(name = "personal_Id")
	private PersonalDtlsForm personalDetails;

	public Long getId() {
		return Id;
	}


	public NomineeDetails(Long id, String firstName, String lastName, String relationship, LocalDate dateOfBirth,
			Double percentage, Boolean minorNominee, String guardianName, String guardianRelationship,
			SchemeSelection schemeSelection) {
		super();
		Id = id;
		this.firstName = firstName;
		LastName = lastName;
		Relationship = relationship;
		DateOfBirth = dateOfBirth;
		Percentage = percentage;
		this.minorNominee = minorNominee;
		this.guardianName = guardianName;
		this.guardianRelationship = guardianRelationship;
		this.schemeSelection = schemeSelection;
	}


	public NomineeDetails() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "NomineeDetails [Id=" + Id + ", firstName=" + firstName + ", LastName=" + LastName + ", Relationship="
				+ Relationship + ", DateOfBirth=" + DateOfBirth + ", Percentage=" + Percentage + ", minorNominee="
				+ minorNominee + ", guardianName=" + guardianName + ", guardianRelationship=" + guardianRelationship
				+ ", schemeSelection=" + schemeSelection + "]";
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getRelationship() {
		return Relationship;
	}


	public void setRelationship(String relationship) {
		Relationship = relationship;
	}


	public LocalDate getDateOfBirth() {
		return DateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}


	public Double getPercentage() {
		return Percentage;
	}


	public void setPercentage(Double percentage) {
		Percentage = percentage;
	}


	public Boolean getMinorNominee() {
		return minorNominee;
	}


	public void setMinorNominee(Boolean minorNominee) {
		this.minorNominee = minorNominee;
	}


	public String getGuardianName() {
		return guardianName;
	}


	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}


	public String getGuardianRelationship() {
		return guardianRelationship;
	}


	public void setGuardianRelationship(String guardianRelationship) {
		this.guardianRelationship = guardianRelationship;
	}


	public SchemeSelection getSchemeSelection() {
		return schemeSelection;
	}


	public void setSchemeSelection(SchemeSelection schemeSelection) {
		this.schemeSelection = schemeSelection;
	}
	
			

}
