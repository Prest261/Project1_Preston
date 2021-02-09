package com.revature.models;

public class TuitionForm {
	
	private int formId;
	private int empId;
	private String eventDate;
	private int eventTime;
	private String eventLocation;
	private String description;
	private int eventCost;
	private String gradeFormat;
	private String eventType;
	private String eventJustification;
	private int approvalStatus;
	private int isUrgent;
	
	
	public TuitionForm() {
		super();
	}


	public TuitionForm(int formId, int empId, String eventDate, int eventTime, String eventLocation, String description,
			int eventCost, String gradeFormat, String eventType, String eventJustification, int approvalStatus, int isUrgent) {
		super();
		this.formId = formId;
		this.empId = empId;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventLocation = eventLocation;
		this.description = description;
		this.eventCost = eventCost;
		this.gradeFormat = gradeFormat;
		this.eventType = eventType;
		this.eventJustification = eventJustification;
		this.approvalStatus = approvalStatus;
		this.isUrgent = isUrgent;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getEventTime() {
		return eventTime;
	}

	public void setEventTime(int eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEventCost() {
		return eventCost;
	}

	public void setEventCost(int eventCost) {
		this.eventCost = eventCost;
	}

	public String getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventJustification() {
		return eventJustification;
	}

	public void setEventJustification(String eventJustification) {
		this.eventJustification = eventJustification;
	}

	public int getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(int isUrgent) {
		this.isUrgent = isUrgent;
	}

	@Override
	public String toString() {
		return "tuitionForm [formId=" + formId + ", empId=" + empId + ", eventDate=" + eventDate + ", eventTime="
				+ eventTime + ", eventLocation=" + eventLocation + ", description=" + description + ", eventCost="
				+ eventCost + ", gradeFormat=" + gradeFormat + ", eventType=" + eventType + ", eventJustification="
				+ eventJustification + ", approvalStatus=" + approvalStatus + ", isUrgent=" + isUrgent +"]";
	}
	
	

}
