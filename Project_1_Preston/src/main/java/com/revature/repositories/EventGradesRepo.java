package com.revature.repositories;

import java.util.List;

import com.revature.models.Event;
import com.revature.models.EventGrades;

public interface EventGradesRepo {

	// CREATE new user
		public boolean createEventGrade(Event event);
		
		// READ 
		EventGrades getEventGradeById(int id);
		
		public List<EventGrades> getAllGrades(Event event);
		
		// Update
		public boolean updateEventGrade(EventGrades egrade, int grade);
		
		// Delete
		boolean deleteEventGrade(EventGrades egrade);
}
