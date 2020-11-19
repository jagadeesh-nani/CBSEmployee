package com.pack.cbs.service;

import java.util.List;

import com.pack.cbs.exception.ResourceNotFoundException;
import com.pack.cbs.model.CBSEmployee;

public interface ICBSEmployeeServices {
	 public List<CBSEmployee> getAllEmployees();
	 public CBSEmployee getEmployeeById(Integer empId) throws ResourceNotFoundException;
	 public boolean deleteEmployee(Integer empId) throws ResourceNotFoundException;
	 public CBSEmployee updateEmployeeById(Integer empId,CBSEmployee employee) throws ResourceNotFoundException;
	 public CBSEmployee saveEmployee(CBSEmployee employee);
}
