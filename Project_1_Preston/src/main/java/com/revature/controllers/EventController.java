package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.revature.models.Event;
import com.revature.models.TuitionForm;
import com.revature.services.EventService;

public class EventController {

	public static EventService es = new EventService();
	public static Gson gson = new Gson();

	public static void createEvent(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		Event event = gson.fromJson(request.getReader(), Event.class);

		int eventId = es.createEvent(event);
		event.setEventId(eventId);

		response.getWriter().append((eventId > 0) ? gson.toJson(event) : "{}");
	}

	public static void updateEvent(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		Event event = gson.fromJson(request.getReader(), Event.class);

		es.updateEvent(event.getFormId(), event.getEventGrade());

		boolean success = event.getEventGrade() > 0;

		response.getWriter().append((success) ? gson.toJson(event) : "{}");
	}

}
