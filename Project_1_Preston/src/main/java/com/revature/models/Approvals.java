package com.revature.models;

public class Approvals {
	
	private int approvalId;
	private int eventId;
	private int supervisorApproval;
	private int departmentHeadApproval;
	private int benCoApproval;
	
	public Approvals() {
		super();
	}
	
	public Approvals(int approvalId, int supervisorApproval) {
		super();
		this.approvalId = approvalId;
		this.supervisorApproval = supervisorApproval;
	}
	
	public Approvals(int supervisorApproval, int departmentHeadApproval, int benCoApproval) {
		super();
		this.supervisorApproval = supervisorApproval;
		this.departmentHeadApproval = departmentHeadApproval;
		this.benCoApproval = benCoApproval;
	}

	public Approvals(int eventId, int supervisorApproval, int departmentHeadApproval, int benCoApproval) {
		super();
		this.eventId = eventId;
		this.supervisorApproval = supervisorApproval;
		this.departmentHeadApproval = departmentHeadApproval;
		this.benCoApproval = benCoApproval;
	}


	public int getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getSupervisorApproval() {
		return supervisorApproval;
	}

	public void setSupervisorApproval(int supervisorApproval) {
		this.supervisorApproval = supervisorApproval;
	}

	public int getDepartmentHeadApproval() {
		return departmentHeadApproval;
	}

	public void setDepartmentHeadApproval(int departmentHeadApproval) {
		this.departmentHeadApproval = departmentHeadApproval;
	}

	public int getBenCoApproval() {
		return benCoApproval;
	}

	public void setBenCoApproval(int benCoApproval) {
		this.benCoApproval = benCoApproval;
	}

	@Override
	public String toString() {
		return "Approvals [approvalId=" + approvalId + ", eventId=" + eventId
				+ ", supervisorApproval=" + supervisorApproval + ", departmentHeadApproval=" + departmentHeadApproval
				+ ", benCoApproval=" + benCoApproval + "]";
	}

}
