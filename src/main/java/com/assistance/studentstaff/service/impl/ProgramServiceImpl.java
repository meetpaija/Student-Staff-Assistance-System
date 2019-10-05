package com.assistance.studentstaff.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.ProgramModel;
import com.assistance.studentstaff.repo.IProgramRepo;
import com.assistance.studentstaff.service.IDepartmentService;
import com.assistance.studentstaff.service.IProgramService;

@Service
public class ProgramServiceImpl implements IProgramService {

	@Autowired
	IProgramRepo progRepo;

	@Autowired
	IDepartmentService deptService;

	@Override
	public List<ProgramModel> fetchAllProgramsByDeptId(String deptId) throws CustomGenericException {
		deptService.findDeptById(deptId);
		return progRepo.findByDeptId(deptId);
	}

	@Override
	public ProgramModel findProgramById(String progId) throws CustomGenericException {
		Optional<ProgramModel> existingProg = progRepo.findById(progId);
		if (existingProg.isPresent()) {
			return existingProg.get();
		} else {
			throw new CustomGenericException("Program doesn't exist");
		}
	}

	@Override
	public ProgramModel insertProgram(String deptId, @Valid ProgramModel prog) throws CustomGenericException {
		deptService.findDeptById(deptId);
		Optional<ProgramModel> existingProg = progRepo.findByProgName(prog.getProgName());
		if (existingProg.isPresent()) {
			throw new CustomGenericException("Program already exist");
		} else {
			deptService.findDeptById(prog.getDeptId());
			prog.setProgId(UUID.randomUUID().toString());
			prog.setDeptId(deptId);
			return progRepo.save(prog);
		}
	}

	@Override
	public ProgramModel updateProgram(String deptId, String progId, @Valid ProgramModel prog)
			throws CustomGenericException {
		findProgramById(progId);
		prog.setProgId(progId);
		prog.setDeptId(deptId);
		return progRepo.save(prog);
	}

	@Override
	public void deleteProgram(String progId) throws CustomGenericException {
		findProgramById(progId);
		progRepo.deleteById(progId);
	}

	@Override
	public List<ProgramModel> fetchAllPrograms() throws CustomGenericException {
		return progRepo.findAll();
	}

}
