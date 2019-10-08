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
import com.assistance.studentstaff.model.DepartmentModel;
import com.assistance.studentstaff.service.IDepartmentService;

@RestController
//@CrossOrigin
@RequestMapping("/departments")
public class DepartmentController extends ResponseUtility {

	@Autowired
	IDepartmentService departmentService;

	@GetMapping
	public ResponseEntity<ApiResponse> fetchAllDepts() {
		return buildSuccessResponse(departmentService.fetchAllDepts());
	}

	@GetMapping("/{deptId}")
	public ResponseEntity<ApiResponse> fetchDeptById(@PathVariable("deptId") String deptId)
			throws CustomGenericException {
		return buildSuccessResponse(departmentService.findDeptById(deptId));
	}

	@PostMapping
	public ResponseEntity<ApiResponse> insertNewDept(@Valid @RequestBody DepartmentModel dept)
			throws CustomGenericException {
		return buildSuccessResponse(departmentService.insertDept(dept));
	}

	@PutMapping("/{deptId}")
	public ResponseEntity<ApiResponse> updateDept(@PathVariable("deptId") String deptId,
			@Valid @RequestBody DepartmentModel dept) throws CustomGenericException {
		return buildSuccessResponse(departmentService.updateDept(deptId, dept));
	}

	@DeleteMapping("/{deptId}")
	public ResponseEntity<ApiResponse> deleteDept(@PathVariable("deptId") String deptId)
			throws CustomGenericException {
		departmentService.deleteDept(deptId);
		return buildSuccessResponse();
	}
}
