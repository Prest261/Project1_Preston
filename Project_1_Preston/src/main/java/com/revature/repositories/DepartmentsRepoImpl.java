package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Departments;
import com.revature.util.JDBCConnection;

public class DepartmentsRepoImpl implements DepartmentsRepo {

	public static Connection conn = JDBCConnection.getConnection();

	
	@Override
	public boolean createDepartment(Departments d) {

		try {

			String sql = "INSERT INTO departments department_name VALUES ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, d.getDepartmentName());

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public Departments getDepartmentById(int id) {
		
		try {

			String sql = "SELECT * FROM departments WHERE department_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Departments d = new Departments();
				d.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				d.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				
				return d;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Departments> getAllDepartments() {
		
		List<Departments> departments = new ArrayList<Departments>();

		try {

			String sql = "SELECT * FROM departments";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Departments d = new Departments();
				d.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				d.setDepartmentName(rs.getString("DEPARTMENT_NAME"));

				departments.add(d);
			}

			return departments;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean updateDepartment(Departments department, String departmentName) {
		
		try {

			String sql = "UPDATE departments SET department_name = ? WHERE department_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, departmentName);
			ps.setString(2, Integer.toString(department.getDepartmentId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteDepartment(Departments d) {
		
		try {

			String sql = "DELETE departments WHERE department_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(d.getDepartmentId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
