package com.assistance.studentstaff.service;

import java.util.List;

import javax.validation.Valid;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.ProgramModel;

public interface IProgramService {

	List<ProgramModel> fetchAllPrograms() throws CustomGenericException;

	List<ProgramModel> fetchAllProgramsByDeptId(String deptId) throws CustomGenericException;

	ProgramModel findProgramById(String deptId) throws CustomGenericException;

	ProgramModel insertProgram(String deptId, @Valid ProgramModel prog) throws CustomGenericException;

	ProgramModel updateProgram(String deptId, String progId, @Valid ProgramModel prog) throws CustomGenericException;

	void deleteProgram(String deptId) throws CustomGenericException;;

}
