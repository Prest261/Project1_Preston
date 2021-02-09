package com.revature.models;

public class Event {

	private int eventId;
	private int formId;
	private String eventType;
	private int eventGrade;
	
	public Event() {
		super();
	}

	public Event(int eventId, int formId, String eventType, int eventGrade) {
		super();
		this.eventId = eventId;
		this.formId = formId;
		this.eventType = eventType;
		this.eventGrade = eventGrade;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public int getEventGrade() {
		return eventGrade;
	}

	public void setEventGrade(int eventGrade) {
		this.eventGrade = eventGrade;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", formId=" + formId + ", eventType=" + eventType + ", eventGrade="
				+ eventGrade + "]";
	}
	
}
