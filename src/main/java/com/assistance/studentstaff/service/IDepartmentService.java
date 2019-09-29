package com.assistance.studentstaff.service;

import java.util.List;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.DepartmentModel;

public interface IDepartmentService {

	List<DepartmentModel> fetchAllDepts();

	DepartmentModel findDeptById(String deptId) throws CustomGenericException;

	DepartmentModel insertDept(DepartmentModel dept) throws CustomGenericException;

	DepartmentModel updateDept(String deptId, DepartmentModel dept) throws CustomGenericException;

	void deleteDept(String deptId) throws CustomGenericException;

}
