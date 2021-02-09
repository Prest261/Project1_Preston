package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Event;
import com.revature.models.EventGrades;
import com.revature.util.JDBCConnection;

public class EventGradesRepoImpl implements EventGradesRepo {

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean createEventGrade(Event event) {
	
		try {

			String sql = "INSERT INTO event_grades (e_id, e_grade) VALUES (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(event.getEventId()));
			ps.setString(2, Integer.toString(event.getEventGrade()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public EventGrades getEventGradeById(int id) {
		
		try {

			String sql = "SELECT * FROM event_grades WHERE e_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				EventGrades eg = new EventGrades();
				eg.setEventId(rs.getInt("E_ID"));
				eg.setEventGrade(rs.getInt("E_GRADE"));

				return eg;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EventGrades> getAllGrades(Event event) {
		
		List<EventGrades> egs = new ArrayList<EventGrades>();

		try {

			String sql = "SELECT * FROM event_grades WHERE e_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(event.getEventId()));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EventGrades eg = new EventGrades();
				eg.setEventId(rs.getInt("E_ID"));
				eg.setEventGrade(rs.getInt("E_GRADE"));
				
				egs.add(eg);
			}

			return egs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean updateEventGrade(EventGrades egrade, int grade) {
		
		try {

			String sql = "UPDATE event_grades SET e_grade = ? WHERE e_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(grade));
			ps.setString(2, Integer.toString(egrade.getEventId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteEventGrade(EventGrades egrade) {

		try {

			String sql = "DELETE event_grades WHERE e_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(egrade.getEventId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
