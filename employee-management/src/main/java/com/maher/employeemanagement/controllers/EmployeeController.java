package com.maher.employeemanagement.controllers;

import com.maher.employeemanagement.entities.Employee;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController
{

	List<Employee> employees = new ArrayList<>();

	{
		employees.add(
				new Employee(UUID.randomUUID(), "Ali Mahmoud", "ali.mahmoud@example.com", "+201112223334", "IT", "Software Engineer", LocalDate.now(),
						15000.00, true, "minia", "298071324000381"));
	}

	@GetMapping()
	private List<Employee> getEmployees()
	{
		return employees;

	}

	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable UUID id)
	{
		return employees.stream().filter(e -> e.getUuid().equals(id)).findAny().orElse(null);
	}

	@PostMapping("")
	public void addEmployee(@RequestBody Employee employee)
	{
		employees.add(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployeeById(@PathVariable UUID id)
	{
		Employee employee = employees.stream().filter(e -> e.getUuid().equals(id)).findAny().orElse(null);

		employees.remove(employee);
	}

}
