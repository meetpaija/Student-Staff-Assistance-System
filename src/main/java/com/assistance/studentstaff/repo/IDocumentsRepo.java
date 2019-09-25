package com.assistance.studentstaff.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.DocumentsModel;

@Repository
public interface IDocumentsRepo extends JpaRepository<DocumentsModel, String> {

	@Query("SELECT doc FROM DocumentsModel doc where doc.docId = :id")
	DocumentsModel findDocumentById(String id);
}
