package com.company.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.employeemanager.exception.UserNotFoundException;
import com.company.employeemanager.model.Employee;
import com.company.employeemanager.repo.EmployeeRepo;

@Service
public class EmployeeService {
	private final EmployeeRepo employeerepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeerepo) {
		super();
		this.employeerepo = employeerepo;
	}
	
	public List<Employee> addEmployees(List<Employee> employees) {
		for(Employee emp:employees)
			emp.setEmpCode(UUID.randomUUID().toString());
		
		return employeerepo.saveAll(employees);
	}
	
	public List<Employee> findAllEmployees(){
		return employeerepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee){
		return employeerepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		return employeerepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id: " + id + "was not found"));
	}
	
	public void deleteEmployee(Long id){
		employeerepo.deleteEmployeeById(id);
	}
}
