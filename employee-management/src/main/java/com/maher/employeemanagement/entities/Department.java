package com.maher.employeemanagement.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Department
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@UuidGenerator()
	@Column(name = "department_id")
	private UUID department_id;

	@Column(name = "name")
	private String name;


	@ManyToMany(mappedBy = "departments")
	Set<Employee> employees = new HashSet<>();


}
