package com.maher.employeemanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@UuidGenerator
	@Column(name = "employee_id")
	private UUID uuid;

	@Column(name = "first_name", length = 15, nullable = false)
	private String name;
	@Column(name = "email", length = 70, nullable = false)
	private String email;
	@Column(name = "phone", length = 11, nullable = false)
	private String phone;
	@Column(name = "job_title", length = 50, nullable = false)
	private String jobTitle;
	@Column(name = "department", length = 50, nullable = false)
	private String department;
	@Column(name = "hire_date", nullable = false)
	private LocalDate hireDate;
	@Column(name = "salary", nullable = false)
	private Double salary;
	@Column(name = "active")
	private Boolean active;
	@Column(name = "address", length = 120)
	private String address;
	@Column(name = "national_id", length = 14, nullable = false)
	private String nationalId;


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_department",
			joinColumns = @JoinColumn(name = "employee_id"),
			inverseJoinColumns = @JoinColumn(name = "department_id")
	)
	Set<Department> departments = new HashSet<>();
}
