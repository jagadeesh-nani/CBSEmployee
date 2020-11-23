package com.pack.cbs.controller;

/** This is a Controller class for CBSEmployee module 
 * 
 * @author Reshma's
 *
 */


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pack.cbs.exception.ResourceNotFoundException;
import com.pack.cbs.model.CBSEmployee;
import com.pack.cbs.service.CBSEmployeeServices;


@RestController
@RequestMapping("/api/v2") 
public class CBSEmployeeController {

	@Autowired 
	private CBSEmployeeServices cbsemployeeservices;
	
	/** 
	 * 
	 *This method returns the list of employee details  
	 * 
	 * 
	 */
	
	@GetMapping("/getAllEmployees")
	public List<CBSEmployee> getAllEmployees() {
		return cbsemployeeservices.getAllEmployees();
	}
	
	/** This method adds the employee details 
	 * 
	 * @param CBSEmployee entity details
	 * 
	 * 
	 */
	
	@PostMapping("/saveEmployee") 
	public CBSEmployee createEmployee( @RequestBody CBSEmployee employee) {
		return cbsemployeeservices.saveEmployee(employee);
	} 
	
	/** 
	 * 
	 *This method returns the list of employee details  
	 * @param CBSEmployee - empId
	 * 
	 */
	
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<CBSEmployee> getEmployeeById(@PathVariable(value = "id") Integer empId) throws ResourceNotFoundException {
		CBSEmployee cbsemp = cbsemployeeservices.getEmployeeById(empId);
		return  ResponseEntity.ok(cbsemp);
	}
	
	
	/** This method updates the employee details 
	 * 
	 * @param CBSEmployee entity details and CBSEmployee - empId
	 * 
	 * 
	 */
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<CBSEmployee> updateEmployee(@PathVariable(value = "id") Integer empId,
			 @RequestBody CBSEmployee employee) throws ResourceNotFoundException {
		CBSEmployee cbsemp = cbsemployeeservices.updateEmployeeById(empId,employee);
		return  ResponseEntity.ok(cbsemp);
	}

	/** This method deletes the employee details 
	 * 
	 * @param CBSEmployee entity details and CBSEmployee - empId
	 * 
	 * 
	 */
	
	
	
	@DeleteMapping("/deleteEmployee/{id}")	
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable(value = "id") Integer empId,
			 @RequestBody CBSEmployee employee) throws ResourceNotFoundException	{
		Boolean emp = cbsemployeeservices.deleteEmployee(empId);
		return  ResponseEntity.ok(emp);
	}
}
