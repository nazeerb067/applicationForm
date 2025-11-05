package com.banking.personalDtls.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "nominee_details")
@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Generates no-args constructor
@AllArgsConstructor // Generates all-args constructor
@Builder // Enables builder pattern
public class NomineeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String relationship;
    private LocalDate dateOfBirth;
    private Double percentageShare;
    private Boolean minorNomineeFlag;

    private String guardianName;
    private String guardianRelationship;

    @ManyToOne
    @JoinColumn(name = "scheme_id")
    private SchemeSelection schemeSelection;

    @ManyToOne
    @JoinColumn(name = "personal_dtls_id")
    private PersonalDtlsForm personalDtlsForm;
}
