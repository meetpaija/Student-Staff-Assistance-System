package com.assistance.studentstaff.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.DocumentsModel;

public interface IDocumentsService {

	List<DocumentsModel> fetchAllDocuments();

	void deleteDocument(String documentId) throws CustomGenericException;

	DocumentsModel findDocumentById(String documentId) throws CustomGenericException;

	DocumentsModel insertDocument(String userId, DocumentsModel document, MultipartFile file)
			throws CustomGenericException;

	DocumentsModel updateDocument(String userId, String documentId, DocumentsModel document, MultipartFile file)
			throws CustomGenericException;
}
