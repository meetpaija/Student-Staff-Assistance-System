package com.assistance.studentstaff.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.DepartmentModel;
import com.assistance.studentstaff.repo.IDepartmentRepo;
import com.assistance.studentstaff.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	IDepartmentRepo deptRepo;
	
	@Override
	public List<DepartmentModel> fetchAllDepts() {
		return deptRepo.findAll();
	}

	@Override
	public DepartmentModel findDeptById(String deptId) throws CustomGenericException {
		Optional<DepartmentModel> existingDept = deptRepo.findById(deptId);
		if(existingDept.isPresent()) {
			return existingDept.get();
		} else {
			throw new CustomGenericException("Department doesn't exist");
		}
	}

	@Override
	public DepartmentModel insertDept(DepartmentModel dept) throws CustomGenericException {
		Optional<DepartmentModel> existingDept = deptRepo.findByDeptName(dept.getDeptName());
		if(existingDept.isPresent()) {
			throw new CustomGenericException("Department already exist");
		} else {
			dept.setDeptId(UUID.randomUUID().toString());
			return deptRepo.save(dept);
		}
	}

	@Override
	public DepartmentModel updateDept(String deptId, DepartmentModel dept) throws CustomGenericException {
		findDeptById(deptId);
		dept.setDeptId(deptId);
		return deptRepo.save(dept);
	}

	@Override
	public void deleteDept(String deptId) throws CustomGenericException {
		findDeptById(deptId);
		deptRepo.deleteById(deptId);
	}

}
