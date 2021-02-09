package com.revature.models;

public class Employee {
	
	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int superId;
	private int tuitionStatus;
	private int departmentId;
	private int departmentHead;
	
	public Employee() {
		super();
	}

	public Employee(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Employee(int empId, String firstName, String lastName, String email, String password, int superId,
			int tuitionStatus, int departmentId, int departmentHead) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.superId = superId;
		this.tuitionStatus = tuitionStatus;
		this.departmentId = departmentId;
		this.departmentHead = departmentHead;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSuperId() {
		return superId;
	}

	public void setSuperId(int superId) {
		this.superId = superId;
	}

	public int getTuitionStatus() {
		return tuitionStatus;
	}

	public int setTuitionStatus(int tuitionStatus) {
		return this.tuitionStatus = tuitionStatus;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(int departmentHead) {
		this.departmentHead = departmentHead;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", superId=" + superId + ", tuitionStatus=" + tuitionStatus
				+ ", departmentId=" + departmentId + ", departmentHead=" + departmentHead + "]";
	}
}
