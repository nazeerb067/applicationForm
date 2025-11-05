package com.banking.personalDtls.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDtlsForm {
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getMidname() {
		return midname;
	}


	public void setMidname(String midname) {
		this.midname = midname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	public ContactDtlsForm getContactDetails() {
		return contactDetails;
	}


	public void setContactDetails(ContactDtlsForm contactDetails) {
		this.contactDetails = contactDetails;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Title;
    private String firstname;
    private String midname;
    private String lastname;
    private LocalDate dob;
    private String Gender;
    private String fatherName;
    private String motherName;
    private String pan;
    
    
    @OneToOne(mappedBy = "personalDetails", cascade = CascadeType.ALL)
    private ContactDtlsForm contactDetails;
    

    @OneToOne(mappedBy = "personalDetails", cascade = CascadeType.ALL)
    private BankDetails bankDetails;
    
    @OneToOne(mappedBy = "personalDetails", cascade = CascadeType.ALL)
    private SchemeSelection schemeSelection;
    
    @OneToMany(mappedBy = "personalDtlsForm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NomineeDetails> nominees = new ArrayList<>();
    
    @OneToOne(mappedBy = "personalDetails", cascade = CascadeType.ALL)
    private UploadDocuments uploadDocumnets;


	public BankDetails getBankDetails() {
		return bankDetails;
	}


	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}


	public SchemeSelection getSchemeSelection() {
		return schemeSelection;
	}


	public void setSchemeSelection(SchemeSelection schemeSelection) {
		this.schemeSelection = schemeSelection;
	}


	public List<NomineeDetails> getNominees() {
		return nominees;
	}


	public void setNominees(List<NomineeDetails> nominees) {
		this.nominees = nominees;
	}



    
    
    
    
    
    
   
}
