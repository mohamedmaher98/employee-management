package com.maher.employeemanagement.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Employee
{
	private UUID uuid;
	private String name;
	private String email;
	private String phone;
	private String jobTitle;
	private String department;
	private LocalDate hireDate;
	private double salary;
	private boolean active;
	private String address;
	private String nationalId;
}
