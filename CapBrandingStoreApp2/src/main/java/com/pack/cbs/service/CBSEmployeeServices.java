package com.pack.cbs.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.pack.cbs.dao.CBSEmployeeRepository;
import com.pack.cbs.exception.ResourceNotFoundException;
import com.pack.cbs.model.CBSEmployee;

@Service

public class CBSEmployeeServices implements ICBSEmployeeServices {

	@Autowired 
	private CBSEmployeeRepository cbsemployeerepository;
	
	public CBSEmployee getEmployeeById(Integer empId) throws ResourceNotFoundException {
		CBSEmployee employee = cbsemployeerepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));
		return employee;
	}
	 public boolean deleteEmployee(Integer empId) throws ResourceNotFoundException {
		 CBSEmployee employee = cbsemployeerepository.findById(empId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));

		 cbsemployeerepository.delete(employee);
		 if(null == employee){
	            return true;
	        }
	        return false;
	}
	 public CBSEmployee updateEmployeeById(Integer empId,CBSEmployee employee) throws ResourceNotFoundException {
		 CBSEmployee emp = cbsemployeerepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));
		 emp.setEmpName(employee.getEmpName());
		 emp.setEmpPhone(employee.getEmpPhone());
		 emp.setEmpEmail(employee.getEmpEmail());
		 emp.setEmpLocation(employee.getEmpLocation());
		final CBSEmployee updatedemployee = cbsemployeerepository.save(emp);
		return updatedemployee; 
		
	}
	 public List<CBSEmployee> getAllEmployees() {
			return cbsemployeerepository.findAll();
		}
		 
		 public CBSEmployee saveEmployee(CBSEmployee employee) {
			return  cbsemployeerepository.save(employee);
			  
			
		}
}
