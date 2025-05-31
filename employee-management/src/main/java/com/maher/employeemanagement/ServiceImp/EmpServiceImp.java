package com.maher.employeemanagement.ServiceImp;

import com.maher.employeemanagement.IService.EmpService;
import com.maher.employeemanagement.entities.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EmpServiceImp implements EmpService
{
	List<Employee> employees = new ArrayList<>();

	{
		employees.add(
				new Employee(UUID.randomUUID(), "Ali Mahmoud", "ali.mahmoud@example.com", "+201112223334", "IT", "Software Engineer", LocalDate.now(),
						15000.00, true, "minia", "298071324000381"));

		employees.add(
				new Employee(UUID.randomUUID(), "Ali Mahmoud", "ali.mahmoud@example.com", "+201112223334", "IT", "Software Engineer", LocalDate.now(),
						15000.00, true, "minia", "298071324000381"));

		employees.add(
				new Employee(UUID.randomUUID(), "Ali Mahmoud", "ali.mahmoud@example.com", "+201112223334", "IT", "Software Engineer", LocalDate.now(),
						15000.00, true, "minia", "298071324000381"));
	}

	@Override
	public Employee findOneEmployee(UUID uuid)
	{
		return employees.stream().filter(e -> e.getUuid().equals(uuid)).findFirst().orElse(null);
	}

	@Override
	public List<Employee> findAllEmployee()
	{
		if (employees.isEmpty())
			return null;
		else
			return employees;
	}

	@Override
	public void deleteEmployee(UUID uuid)
	{
		Employee employee = employees.stream().filter(e -> e.getUuid().equals(uuid)).findFirst().orElse(null);
		employees.remove(employee);
	}

	@Override
	public Employee editEmployee(Employee employee, UUID uuid)
	{
		Employee employee1 = employees.stream().filter(e -> e.getUuid().equals(uuid)).findFirst().orElse(null);
		if(employee1!=null)
		{
			employee1.setName(employee.getName());
			employee1.setEmail(employee.getEmail());
			employee1.setPhone(employee.getPhone());
			employee1.setJobTitle(employee.getJobTitle());
			employee1.setDepartment(employee.getDepartment());
			employee1.setHireDate(employee.getHireDate());
			employee1.setSalary(employee.getSalary());
			employee1.setActive(employee.isActive());
			employee1.setAddress(employee.getAddress());
			employee1.setNationalId(employee.getNationalId());
		}
		return employee1;
	}

	@Override
	public void addEmployee(Employee employee)
	{
		employees.add(employee);
	}
}
