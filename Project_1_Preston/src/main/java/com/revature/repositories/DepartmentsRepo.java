package com.revature.repositories;

import java.util.List;

import com.revature.models.Departments;

public interface DepartmentsRepo {

	// CREATE new department
		public boolean createDepartment(Departments d);
		
		// READ 
		Departments getDepartmentById(int id);
		
		public List<Departments> getAllDepartments();
		
		// Update
		public boolean updateDepartment(Departments department, String departmentName);
		
		// Delete
		boolean deleteDepartment(Departments d);
		
}
