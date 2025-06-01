package com.maher.employeemanagement.ServiceImp;

import com.maher.employeemanagement.IService.EmpService;
import com.maher.employeemanagement.dtos.*;
import com.maher.employeemanagement.entities.Employee;
import com.maher.employeemanagement.mapper.EmployeeMapper;
import com.maher.employeemanagement.reposatiry.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EmpServiceImp implements EmpService
{
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee findOneEmployee(UUID uuid)
	{
		return employeeRepo.findById(uuid).orElse(null);
	}

	@Override
	public List<Employee> findAllEmployee()
	{
		if (!employeeRepo.findAll().isEmpty())
			return employeeRepo.findAll();
		else
			return null;
	}

	@Override
	public void deleteEmployee(UUID uuid)
	{
		if (employeeRepo.existsById(uuid))
			employeeRepo.deleteById(uuid);

	}

	@Override
	public Employee editEmployee(EmployeeUpdateDTO employeeDto, UUID uuid)
	{
		if (employeeRepo.existsById(uuid))
		{
			Employee originEmp = employeeRepo.findById(uuid).get();
			EmployeeMapper.fromUpdateDto(originEmp, employeeDto);
			return employeeRepo.save(originEmp);
		}
		return null;
	}

	@Override
	public void addEmployee(EmployeeCreateDTO employee)
	{
		employeeRepo.save(EmployeeMapper.fromCrateDto(employee));
	}
}
