package com.assistance.studentstaff.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.model.ProgramModel;
import com.assistance.studentstaff.service.IProgramService;

@RestController
@CrossOrigin
@RequestMapping
public class ProgramController extends ResponseUtility {

	@Autowired
	IProgramService programService;

	@GetMapping("/departments/{deptId}/programs")
	public ResponseEntity<ApiResponse> fetchAllPrograms(@PathVariable("deptId") String deptId) {
		return buildSuccessResponse(programService.fetchAllPrograms(deptId));
	}

	@GetMapping("/programs/{progId}")
	public ResponseEntity<ApiResponse> fetchProgramById(@PathVariable("progId") String progId)
			throws CustomGenericException {
		return buildSuccessResponse(programService.findProgramById(progId));
	}

	@PostMapping("/departments/{deptId}/programs")
	public ResponseEntity<ApiResponse> insertNewProgram(@PathVariable("deptId") String deptId, @Valid @RequestBody ProgramModel prog)
			throws CustomGenericException {
		return buildSuccessResponse(programService.insertProgram(deptId, prog));
	}

	@PutMapping("/departments/{deptId}/programs/{progId}")
	public ResponseEntity<ApiResponse> updateProgram(@PathVariable("deptId") String deptId, @PathVariable("progId") String progId,
			@Valid @RequestBody ProgramModel prog) throws CustomGenericException {
		return buildSuccessResponse(programService.updateProgram(deptId, progId, prog));
	}

	@DeleteMapping("/programs/{progId}")
	public ResponseEntity<ApiResponse> deleteProgram(@PathVariable("progId") String progId)
			throws CustomGenericException {
		programService.deleteProgram(progId);
		return buildSuccessResponse();
	}
}
