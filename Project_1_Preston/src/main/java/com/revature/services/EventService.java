package com.revature.services;

import java.util.List;

import com.revature.models.Event;
import com.revature.models.TuitionForm;
import com.revature.repositories.EventRepo;
import com.revature.repositories.EventRepoImpl;

public class EventService {
	
	private EventRepo er = new EventRepoImpl();
	
	public int createEvent(Event event) {
		return er.createEvent(event);
	}
	
	public Event getEventByFormId(TuitionForm tf) {
		return er.getEventByFormId(tf);
	}

	public List<Event> getAllEvents() {
		return er.getAllEvents();
	}

	// Update
	public boolean updateEvent(int id, int grade) {
		return er.updateEvent(id, grade);
	}

	// Delete
	boolean deleteEvent(Event event) {
		return er.deleteEvent(event);
	}

}
