package com.company.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	// Those are query methods, the magic of spring!
	Object deleteEmployeeById(Long id);
	Optional<Employee> findEmployeeById(Long id);  // optional means ya trg3 ya mtrg3sh xD
}
