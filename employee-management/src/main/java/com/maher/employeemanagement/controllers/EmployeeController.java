package com.maher.employeemanagement.controllers;

import com.maher.employeemanagement.entities.Employee;
import jakarta.validation.Valid;
import org.springframework.http.*;
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

		employees.add(
				new Employee(UUID.randomUUID(), "Ali Mahmoud", "ali.mahmoud@example.com", "+201112223334", "IT", "Software Engineer", LocalDate.now(),
						15000.00, true, "minia", "298071324000381"));

		employees.add(
				new Employee(UUID.randomUUID(), "Ali Mahmoud", "ali.mahmoud@example.com", "+201112223334", "IT", "Software Engineer", LocalDate.now(),
						15000.00, true, "minia", "298071324000381"));
	}

	@GetMapping()
	private ResponseEntity<List<Employee>> getEmployees()
	{
		return ResponseEntity.ok(employees);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable UUID id)
	{
		Optional<Employee> employee = employees.stream().filter(e -> e.getUuid().equals(id)).findFirst();

		return employee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping()
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee)
	{
		employees.add(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable UUID id)
	{
		Optional<Employee> employee = employees.stream().filter(e -> e.getUuid().equals(id)).findFirst();

		if (employee.isPresent())
			return ResponseEntity.ok("employee had deleted successfully");
		else
			return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> editEmployee(@PathVariable UUID id, @RequestBody @Valid Employee employee)
	{
		Optional<Employee> eEmployee = employees.stream().filter(e -> e.getUuid().equals(id)).findFirst();

		if (eEmployee.isPresent())
		{
			Employee existingEmployee = eEmployee.get();
			existingEmployee.setName(employee.getName());
			existingEmployee.setEmail(employee.getEmail());
			existingEmployee.setPhone(employee.getPhone());
			existingEmployee.setJobTitle(employee.getJobTitle());
			existingEmployee.setDepartment(employee.getDepartment());
			existingEmployee.setHireDate(employee.getHireDate());
			existingEmployee.setSalary(employee.getSalary());
			existingEmployee.setActive(employee.isActive());
			existingEmployee.setAddress(employee.getAddress());
			existingEmployee.setNationalId(employee.getNationalId());
			return ResponseEntity.ok(existingEmployee);
		}
		else
			return ResponseEntity.notFound().build();
	}

}
