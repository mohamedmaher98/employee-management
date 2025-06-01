package com.maher.employeemanagement.IService;

import com.maher.employeemanagement.dtos.*;
import com.maher.employeemanagement.entities.Employee;

import java.util.*;

public interface EmpService
{
	Employee findOneEmployee(UUID uuid);

	List<Employee> findAllEmployee();

	void deleteEmployee(UUID uuid);

	Employee editEmployee(EmployeeUpdateDTO employee, UUID uuid);

	void addEmployee(EmployeeCreateDTO employee);

}
