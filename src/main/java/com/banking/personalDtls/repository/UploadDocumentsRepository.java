package com.banking.personalDtls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.personalDtls.entity.UploadDocuments;


@Repository
public interface UploadDocumentsRepository  extends JpaRepository<UploadDocuments, Long>{

}
