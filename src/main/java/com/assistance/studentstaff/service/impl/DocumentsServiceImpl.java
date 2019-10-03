package com.assistance.studentstaff.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.DocumentsModel;
import com.assistance.studentstaff.repo.IDocumentsRepo;
import com.assistance.studentstaff.repo.IUserRepo;
import com.assistance.studentstaff.service.IDocumentsService;

@Service
public class DocumentsServiceImpl implements IDocumentsService {

	@Autowired
	IDocumentsRepo documentsRepo;

	@Autowired
	IUserRepo userRepo;

	@Override
	public List<DocumentsModel> fetchAllDocuments() {
		return documentsRepo.findAll();
	}

	@Override
	public DocumentsModel insertDocument(String userId, DocumentsModel document, MultipartFile file)
			throws CustomGenericException {
		document.setCreatedBy(userId);
		document.setUpdatedBy(userId);
		document.setDocId(UUID.randomUUID().toString());
		document.setTimestamp(Timestamp.from(Calendar.getInstance().toInstant()));
		document.setContentType(file.getContentType());
		document.setLength(file.getSize());
		try {
			document.setDocFile(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return documentsRepo.save(document);
	}

	@Override
	public DocumentsModel updateDocument(String userId, String documentId, DocumentsModel document, MultipartFile file)
			throws CustomGenericException {
		DocumentsModel model = documentsRepo.findDocumentById(documentId);
		if (model != null) {
			model.setUpdatedBy(userId);
			model.setTimestamp(Timestamp.from(Calendar.getInstance().toInstant()));
			if (!file.isEmpty()) {
				model.setContentType(file.getContentType());
				model.setLength(file.getSize());
				model.setDocDesc(document.getDocDesc());
				model.setDocTitle(document.getDocTitle());
				model.setDocType(document.getDocType());
				try {
					document.setDocFile(file.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return documentsRepo.save(model);
		} else {
			throw new CustomGenericException("document doesn't exists");
		}
	}

	@Override
	public void deleteDocument(String documentId) throws CustomGenericException {
		DocumentsModel model = documentsRepo.findDocumentById(documentId);
		if (model != null) {
			documentsRepo.deleteById(documentId);
		} else {
			throw new CustomGenericException("document doesn't exists");
		}
	}

	@Override
	public DocumentsModel findDocumentById(String documentId) throws CustomGenericException {
		DocumentsModel model = documentsRepo.findDocumentById(documentId);
		if (model != null) {
			return model;
		} else {
			throw new CustomGenericException("document doesn't exists");
		}
	}
}
