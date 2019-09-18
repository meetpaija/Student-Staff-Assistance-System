package com.assistance.studentstaff.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

public class ResponseUtility {

	public ResponseEntity<ApiResponse> buildSuccessResponse(Object data) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(data);
		apiResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	public ResponseEntity<ApiResponse> successResponse(Object data) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(data);
		apiResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	public ResponseEntity<ApiResponse> buildSuccessResponse() {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	public ResponseEntity<Object> buildErrorResponse(Exception ex, HttpStatus status, String message) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setTimestamp(System.currentTimeMillis());
		buildErrorMap(ex, message, apiResponse);
		return new ResponseEntity<Object>(apiResponse, status);
	}

	public ResponseEntity<ApiResponse> buildFileFetchSuccessResponse(InputStreamResource inputStreamResource,
			MediaType parseMediaType, long length) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setTimestamp(System.currentTimeMillis());
		apiResponse.setData(inputStreamResource);
		return ResponseEntity.ok().contentLength(length).contentType(parseMediaType).body(apiResponse);
	}

	private void buildErrorMap(Exception ex, String message, ApiResponse apiResponse) {
		Map<String, Object> error = new HashMap<String, Object>();
		error.put("message", message);
		if(ex instanceof CustomGenericException) {
			error.put("developerMessage", ((CustomGenericException) ex).getErrDebugMsg());
		} else {
			if(StringUtils.isEmpty(ex.getMessage()))
				error.put("developerMessage", ex.getMessage());
		}
		apiResponse.setError(error);
	}

}
