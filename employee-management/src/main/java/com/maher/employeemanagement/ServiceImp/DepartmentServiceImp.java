package com.maher.employeemanagement.ServiceImp;

import com.maher.employeemanagement.IService.DepartService;
import com.maher.employeemanagement.entities.Department;
import com.maher.employeemanagement.reposatiry.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentServiceImp implements DepartService
{
	@Autowired
	private DepartmentRepo repo;

	@Override
	public Department addDepartment(Department department)
	{
		repo.save(department);
		return department;
	}

	@Override
	public List<Department> findAll()
	{
		return repo.findAll();
	}

	@Override
	public Department findById(UUID id)
	{
		return repo.findById(id).orElse(null);
	}

	@Override
	public void deleteById(UUID id)
	{
			repo.deleteById(id);
	}

	@Override
	public Department updateById(Department department, UUID id)
	{
		Department oldDepartment = repo.findById(id).orElse(null);
		if (department != null)
		{
			oldDepartment.setName(department.getName());
			repo.save(oldDepartment);
			return oldDepartment;
		}
		else
			return null;
	}
}
