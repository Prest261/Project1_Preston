package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeRepo {
	
	// CREATE new employee
		public boolean createEmployee(Employee emp);
		
		// READ 
		Employee getEmployeeById(int id);
		Employee getEmployeeByUsername(String username);
		Employee login(String email, String password);
		
		public List<Employee> getAllEmployees();
		
		//public List<Employee> supervisorGetEmployees();
		
		// Update
		public boolean updateEmployee(Employee emp, int tuitionStatus);
		
		// Delete
		boolean deleteEmployee(Employee emp);
}
