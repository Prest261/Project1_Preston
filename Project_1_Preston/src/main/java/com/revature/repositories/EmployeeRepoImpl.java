package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.JDBCConnection;

public class EmployeeRepoImpl implements EmployeeRepo {

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public Employee getEmployeeById(int id) {

		try {

			String sql = "SELECT * FROM employees WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setFirstName(rs.getString("F_NAME"));
				emp.setLastName(rs.getString("L_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setSuperId(rs.getInt("SUPERVISOR_ID"));
				emp.setTuitionStatus(rs.getInt("TUITION_STATUS"));
				emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				emp.setDepartmentHead(rs.getInt("DEPARTMENT_HEAD"));

				return emp;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee login(String email, String password) {

		try {

			String sql = "SELECT * FROM employees WHERE email = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setFirstName(rs.getString("F_NAME"));
				emp.setLastName(rs.getString("L_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setSuperId(rs.getInt("SUPERVISOR_ID"));
				emp.setTuitionStatus(rs.getInt("TUITION_STATUS"));
				emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				emp.setDepartmentHead(rs.getInt("DEPARTMENT_HEAD"));

				return emp;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emps = new ArrayList<Employee>();

		try {

			String sql = "SELECT * FROM employees";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setFirstName(rs.getString("F_NAME"));
				emp.setLastName(rs.getString("L_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setSuperId(rs.getInt("SUPERVISOR_ID"));
				emp.setTuitionStatus(rs.getInt("TUITION_STATUS"));
				emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				emp.setDepartmentHead(rs.getInt("DEPARTMENT_HEAD"));

				emps.add(emp);
			}

			return emps;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateEmployee(Employee emp, int tuitionStatus) {

		try {

			String sql = "UPDATE employees SET tuition_status = ? WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(tuitionStatus));
			ps.setString(2, Integer.toString(emp.getEmpId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean createEmployee(Employee emp) {

		try {

			String sql = "INSERT INTO employees(f_name, l_name, email, password, supervisor_id, department_id, department_head) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getPassword());
			ps.setString(5, Integer.toString(emp.getSuperId()));
			ps.setString(6, Integer.toString(emp.getDepartmentId()));
			ps.setString(7, Integer.toString(emp.getDepartmentHead()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee emp) {

		try {

			String sql = "DELETE employees WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(emp.getEmpId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {

			try {

				String sql = "SELECT * FROM employees WHERE email = ?";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					Employee emp = new Employee();
					emp.setEmpId(rs.getInt("EMP_ID"));
					emp.setFirstName(rs.getString("F_NAME"));
					emp.setLastName(rs.getString("L_NAME"));
					emp.setEmail(rs.getString("EMAIL"));
					emp.setPassword(rs.getString("PASSWORD"));
					emp.setSuperId(rs.getInt("SUPERVISOR_ID"));
					emp.setTuitionStatus(rs.getInt("TUITION_STATUS"));
					emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
					emp.setDepartmentHead(rs.getInt("DEPARTMENT_HEAD"));

					return emp;

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}

//	@Override
//	public List<Employee> supervisorGetEmployees() {
//		
//		List<Employee> emps = new ArrayList<Employee>();
//
//		try {
//
//			String sql = "";
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				Employee emp = new Employee();
//				emp.setEmpId(rs.getInt("EMP_ID"));
//				emp.setFirstName(rs.getString("F_NAME"));
//				emp.setLastName(rs.getString("L_NAME"));
//				emp.setEmail(rs.getString("EMAIL"));
//				emp.setPassword(rs.getString("PASSWORD"));
//				emp.setSuperId(rs.getInt("SUPERVISOR_ID"));
//				emp.setTuitionStatus(rs.getInt("TUITION_STATUS"));
//				emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
//				emp.setDepartmentHead(rs.getInt("DEPARTMENT_HEAD"));
//
//				emps.add(emp);
//			}
//
//			return emps;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

}
