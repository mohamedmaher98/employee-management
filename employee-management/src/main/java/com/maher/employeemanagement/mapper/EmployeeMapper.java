package com.maher.employeemanagement.mapper;

import com.maher.employeemanagement.dtos.*;
import com.maher.employeemanagement.entities.Employee;

import java.util.UUID;

public class EmployeeMapper
{
	public static Employee fromCrateDto(EmployeeCreateDTO empDto)
	{
		Employee emp = new Employee();
		emp.setName(empDto.name());
		emp.setEmail(empDto.email());
		emp.setPhone(empDto.phone());
		emp.setJobTitle(empDto.jobTitle());
		emp.setDepartment(empDto.department());
		emp.setHireDate(empDto.hireDate());
		emp.setSalary(empDto.salary());
		emp.setActive(empDto.active());
		emp.setAddress(empDto.address());
		emp.setNationalId(empDto.nationalId());

		return emp;
	}

	public static void fromUpdateDto(Employee employee, EmployeeUpdateDTO updateDTO)
	{
		if (updateDTO.name() != null) employee.setName(updateDTO.name());
		if (updateDTO.phone() != null) employee.setPhone(updateDTO.phone());
		if (updateDTO.address() != null) employee.setAddress(updateDTO.address());
		if (updateDTO.salary() != null) employee.setSalary(updateDTO.salary());
		if (updateDTO.jobTitle() != null) employee.setJobTitle(updateDTO.jobTitle());
		if (updateDTO.active() != null) employee.setActive(updateDTO.active());

	}
}
