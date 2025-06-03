package com.maher.employeemanagement.IService;

import com.maher.employeemanagement.entities.Department;

import java.util.*;

public interface DepartService
{
	Department addDepartment(Department department);

	List<Department> findAll();

	Department findById(UUID id);

	void deleteById(UUID id);

	Department updateById(Department department, UUID id);

}
