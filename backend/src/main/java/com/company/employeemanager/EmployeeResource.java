package com.company.employeemanager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.employeemanager.model.Employee;
import com.company.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	private final EmployeeService employeeService;

	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/all")
	// this method returns an HTTP response that contains a list of employees
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<List<Employee>> addEmployees(@RequestBody List<Employee> employees){
		List<Employee> emps = employeeService.addEmployees(employees);
		return new ResponseEntity<>(emps, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee emp = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@Transactional
	public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	} 
}