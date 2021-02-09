package com.revature.models;

public class EventGrades {
	
	private int eventId;
	private int eventGrade;
	
	public EventGrades() {
		super();
	}
	public EventGrades(int eventId, int eventGrade) {
		super();
		this.eventId = eventId;
		this.eventGrade = eventGrade;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getEventGrade() {
		return eventGrade;
	}
	public void setEventGrade(int eventGrade) {
		this.eventGrade = eventGrade;
	}
	
	@Override
	public String toString() {
		return "EventGrades [eventId=" + eventId + ", eventGrade=" + eventGrade + "]";
	}
	

}
