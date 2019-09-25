package com.assistance.studentstaff.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.model.DocumentsModel;
import com.assistance.studentstaff.service.IDocumentsService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/documents")
public class DocumentsController extends ResponseUtility {

	IDocumentsService documentsServices;

	@GetMapping
	public ResponseEntity<ApiResponse> fetchAllDocuments() {
		return buildSuccessResponse(documentsServices.fetchAllDocuments());
	}

	@GetMapping("/{documentId}")
	public ResponseEntity<ApiResponse> fetchDocumentById(@PathVariable("documentId") String documentId)
			throws CustomGenericException {
		return buildSuccessResponse(documentsServices.findDocumentById(documentId));
	}

	@PostMapping("/users/{userId}/documents")
	public ResponseEntity<ApiResponse> insertDocument(@PathVariable("userId") String userId,
			@RequestPart(name = "data") String documentJson, @RequestPart(name = "file") MultipartFile file)
			throws CustomGenericException, JsonParseException, JsonMappingException, IOException {
		DocumentsModel document = new ObjectMapper().readValue(documentJson, DocumentsModel.class);
		return buildSuccessResponse(documentsServices.insertDocument(userId, document, file));
	}

	@PutMapping("/users/{userId}/{documentId}")
	public ResponseEntity<ApiResponse> updateDocument(@PathVariable("userId") String userId,
			@PathVariable("documentId") String documentId, @RequestPart(name = "data") String documentJson,
			@RequestPart(name = "file") MultipartFile file)
			throws CustomGenericException, JsonParseException, JsonMappingException, IOException {
		DocumentsModel document = new ObjectMapper().readValue(documentJson, DocumentsModel.class);
		return buildSuccessResponse(documentsServices.updateDocument(userId, documentId, document, file));
	}

	@DeleteMapping("/{documentId}")
	public ResponseEntity<ApiResponse> deleteDocument(@PathVariable("documentId") String documentId)
			throws CustomGenericException {
		documentsServices.deleteDocument(documentId);
		return buildSuccessResponse();
	}
}
