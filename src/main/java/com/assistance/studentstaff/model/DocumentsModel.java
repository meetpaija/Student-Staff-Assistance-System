package com.assistance.studentstaff.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "document_master")
@JsonInclude(value = Include.NON_NULL)
public class DocumentsModel implements Serializable {

	private static final long serialVersionUID = 8744593027511420387L;

	@Id
	@Column(name = "doc_id", nullable = false)
	private String docId;

	@Column(name = "length", nullable = false)
	private long length;

	@Column(name = "content_type", nullable = false)
	private String contentType;

	@Lob
	@Column(name = "doc_file", nullable = false)
	private byte[] docFile;

	@Column(name = "doc_type", nullable = false)
	private String docType;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "updated_by", nullable = false)
	private String updatedBy;
	
	@Column(name = "doc_title")
	private String docTitle;
	
	@Column(name = "doc_desc")
	private String docDesc;

	@Column(name = "timestamp", nullable = false)
	private Timestamp timestamp;

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getDocFile() {
		return docFile;
	}

	public void setDocFile(byte[] docFile) {
		this.docFile = docFile;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getDocTitle() {
		return docTitle;
	}

	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}

	public String getDocDesc() {
		return docDesc;
	}

	public void setDocDesc(String docDesc) {
		this.docDesc = docDesc;
	}
	
}
