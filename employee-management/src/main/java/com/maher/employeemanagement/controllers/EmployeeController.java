package com.maher.employeemanagement.controllers;

import com.maher.employeemanagement.IService.EmpService;
import com.maher.employeemanagement.dtos.EmployeeUpdateDTO;
import com.maher.employeemanagement.entities.Employee;
import com.maher.employeemanagement.shared.GlobalErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController
{
	private final EmpService empService;

	@Autowired
	public EmployeeController(EmpService empService)
	{
		this.empService = empService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<GlobalErrorResponse<Employee>> findOneEmp(@PathVariable UUID id)
	{
		Employee oneEmployee = empService.findOneEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body(new GlobalErrorResponse<>(oneEmployee));
	}

	@GetMapping
	public ResponseEntity<GlobalErrorResponse<List<Employee>>> findAllEmployees()
	{
		List<Employee> allEmployee = empService.findAllEmployee();
		return ResponseEntity.status(HttpStatus.OK).body(new GlobalErrorResponse<>(allEmployee));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<GlobalErrorResponse<?>> deleteEmp(@PathVariable("id") UUID uuid)
	{
		empService.deleteEmployee(uuid);
		return ResponseEntity.ok().build();
	}

	@PostMapping
	public ResponseEntity<GlobalErrorResponse<?>> addEmployee(@RequestBody @Valid Employee employee)
	{
		empService.addEmployee(employee);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<GlobalErrorResponse<Employee>> editEmployee(@RequestBody @Valid EmployeeUpdateDTO employee,@PathVariable("id") UUID uuid)
	{
		Employee employee1 = empService.editEmployee(employee, uuid);
		return ResponseEntity.status(HttpStatus.OK).body(new GlobalErrorResponse<>(employee1));
	}

}
