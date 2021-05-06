package com.cg.fms.service;

import java.util.List;

import com.cg.fms.model.EmployeeModel;

public interface ITrainerManagement {



	public EmployeeModel addTrainer(EmployeeModel employeeMaster) throws Exception;

	public boolean removeEmployee(long employeeId) throws Exception;

	public EmployeeModel getById(long id) throws Exception;	

	public List<EmployeeModel> getAll();

}
