package com.maher.employeemanagement.IService;

import com.maher.employeemanagement.dtos.EmployeeUpdateDTO;
import com.maher.employeemanagement.entities.Employee;
import com.maher.employeemanagement.shared.GlobalErrorResponse;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface EmpService
{
	Employee findOneEmployee(UUID uuid);

	List<Employee> findAllEmployee();

	void deleteEmployee(UUID uuid);

	Employee editEmployee(EmployeeUpdateDTO employee, UUID uuid);

	void addEmployee(Employee employee);

}
