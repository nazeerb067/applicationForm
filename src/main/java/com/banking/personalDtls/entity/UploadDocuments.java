package com.banking.personalDtls.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "upload_documents")
public class UploadDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String photoFileData;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String signatureFileData;

    private String subscriberDeclaration;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_id", referencedColumnName = "id") // 👈 Correct FK column name
    private PersonalDtlsForm personalDetails;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoFileData() {
        return photoFileData;
    }

    public void setPhotoFileData(String photoFileData) {
        this.photoFileData = photoFileData;
    }

    public String getSignatureFileData() {
        return signatureFileData;
    }

    public void setSignatureFileData(String signatureFileData) {
        this.signatureFileData = signatureFileData;
    }

    public String getSubscriberDeclaration() {
        return subscriberDeclaration;
    }

    public void setSubscriberDeclaration(String subscriberDeclaration) {
        this.subscriberDeclaration = subscriberDeclaration;
    }

    public PersonalDtlsForm getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDtlsForm personalDetails) {
        this.personalDetails = personalDetails;
    }
}
