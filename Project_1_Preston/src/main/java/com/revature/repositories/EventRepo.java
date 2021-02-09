package com.revature.repositories;

import java.util.List;

import com.revature.models.Event;
import com.revature.models.TuitionForm;

public interface EventRepo {

	// CREATE new event
	public int createEvent(Event event);

	// READ
	Event getEventByFormId(TuitionForm tf);

	public List<Event> getAllEvents();

	// Update
	public boolean updateEvent(int id, int grade);

	// Delete
	boolean deleteEvent(Event event);
}
