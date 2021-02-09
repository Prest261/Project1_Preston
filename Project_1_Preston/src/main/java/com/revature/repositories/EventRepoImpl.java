package com.revature.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Event;
import com.revature.models.TuitionForm;
import com.revature.util.JDBCConnection;

import oracle.jdbc.OracleTypes;

public class EventRepoImpl implements EventRepo {

	public static Connection conn = JDBCConnection.getConnection();
	
	@Override
	public int createEvent(Event event) {
		
		System.out.println(event);
		
		try {

			String sql = "CALL add_event(?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setString(1, Integer.toString(event.getFormId()));
			cs.setString(2, event.getEventType());
			cs.setString(3, Integer.toString(event.getEventGrade()));
			
			cs.registerOutParameter(4, OracleTypes.NUMBER);

			cs.execute();
			int eventId = cs.getInt(4);
			System.out.println(eventId);
			
			return eventId;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Event getEventByFormId(TuitionForm tf) {
		
		try {

			String sql = "SELECT * FROM events WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(tf.getFormId()));
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Event event = new Event();
				event.setEventId(rs.getInt("EVENT_ID"));
				event.setFormId(rs.getInt("FORM_ID"));
				event.setEventType(rs.getString("EVENT_TYPE"));
				event.setEventGrade(rs.getInt("EVENT_GRADE"));

				return event;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return null;
	}

	@Override
	public List<Event> getAllEvents() {
		
		List<Event> events = new ArrayList<Event>();

		try {

			String sql = "SELECT * FROM events";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Event event = new Event();
				event.setEventId(rs.getInt("EVENT_ID"));
				event.setFormId(rs.getInt("FORM_ID"));
				event.setEventType(rs.getString("EVENT_TYPE"));
				event.setEventGrade(rs.getInt("EVENT_GRADE"));

				events.add(event);
			}

			return events;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateEvent(int id, int grade) {
		
		try {

			String sql = "UPDATE events SET event_grade = ? WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(grade));
			ps.setString(2, Integer.toString(id));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteEvent(Event event) {
		
		try {

			String sql = "DELETE events WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(event.getEventId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
