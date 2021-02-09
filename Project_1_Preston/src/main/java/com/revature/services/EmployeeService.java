package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeRepo;
import com.revature.repositories.EmployeeRepoImpl;

public class EmployeeService {

	private EmployeeRepo er = new EmployeeRepoImpl();

	public boolean createEmployee(Employee emp) {
		return er.createEmployee(emp);
	}
	
	public Employee getEmployeeById(int id) {
		return er.getEmployeeById(id);
	}
	
	public Employee getEmployeeByUsername(String username) {
		return er.getEmployeeByUsername(username);
	}

	public Employee login(String email, String password) {
		return er.login(email, password);
	}
		
	public List<Employee> getAllEmployees() {
		return er.getAllEmployees();
	}
	
	public boolean updateEmployee(Employee emp, int tuitionStatus) {
		return er.updateEmployee(emp, tuitionStatus);
	}
	
	public boolean deleteEmployee(Employee emp) {
		return er.deleteEmployee(emp);
	}

}
