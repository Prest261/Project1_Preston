package com.revature.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Approvals;
import com.revature.models.Employee;
import com.revature.models.TuitionForm;
import com.revature.util.JDBCConnection;

import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

public class TuitionFormRepoImpl implements TuitionFormRepo {

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	// return int instead of boolean so that it returns the int of the form_id
	public int createForm(TuitionForm tf) {

		System.out.println(tf);

		try {

			String sql = "CALL add_tuitionForm(?,?,?,?,?,?,?,?,?,?,?)";

//			String sql = "INSERT INTO tuition_forms(emp_id, event_date, event_time, event_location, event_desc, "
//					+ "event_cost, event_gradeformat, event_type, event_justification, is_urgent) "
//					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setString(1, Integer.toString(tf.getEmpId()));
			cs.setString(2, tf.getEventDate());
			cs.setString(3, Integer.toString(tf.getEventTime()));
			cs.setString(4, tf.getEventLocation());
			cs.setString(5, tf.getDescription());
			cs.setString(6, Integer.toString(tf.getEventCost()));
			cs.setString(7, tf.getGradeFormat());
			cs.setString(8, tf.getEventType());
			cs.setString(9, tf.getEventJustification());
			cs.setString(10, Integer.toString(tf.getIsUrgent()));

			// getting back the form_id seq
			cs.registerOutParameter(11, OracleTypes.NUMBER);

			cs.execute();
			int formId = cs.getInt(11);
			System.out.println(formId);

			return formId;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<TuitionForm> getFormsByEmpId(int id) {
		
		List<TuitionForm> forms = new ArrayList<TuitionForm>();

		try {

			String sql = "SELECT * FROM employees\r\n"
					+ "INNER JOIN tuition_forms ON tuition_forms.emp_id = employees.emp_id \r\n"
					+ "WHERE employees.emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				TuitionForm tf = new TuitionForm();
				tf.setFormId(rs.getInt("FORM_ID"));
				tf.setEmpId(rs.getInt("EMP_ID"));
				tf.setEventDate(rs.getString("EVENT_DATE"));
				tf.setEventTime(rs.getInt("EVENT_TIME"));
				tf.setEventLocation(rs.getString("EVENT_LOCATION"));
				tf.setDescription(rs.getString("EVENT_DESC"));
				tf.setEventCost(rs.getInt("EVENT_COST"));
				tf.setGradeFormat(rs.getString("EVENT_GRADEFORMAT"));
				tf.setEventType(rs.getString("EVENT_TYPE"));
				tf.setEventJustification(rs.getString("EVENT_JUSTIFICATION"));
				tf.setApprovalStatus(rs.getInt("APPROVAL_STATUS"));
				tf.setIsUrgent(rs.getInt("IS_URGENT"));

				forms.add(tf);
			}

			return forms;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TuitionForm> getAllForms(int id) {

		List<TuitionForm> forms = new ArrayList<TuitionForm>();

		try {

			String sql = "SELECT * FROM tuition_forms WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				TuitionForm tf = new TuitionForm();
				tf.setFormId(rs.getInt("FORM_ID"));
				tf.setEmpId(rs.getInt("EMP_ID"));
				tf.setEventDate(rs.getString("EVENT_DATE"));
				tf.setEventTime(rs.getInt("EVENT_TIME"));
				tf.setEventLocation(rs.getString("EVENT_LOCATION"));
				tf.setDescription(rs.getString("EVENT_DESC"));
				tf.setEventCost(rs.getInt("EVENT_COST"));
				tf.setGradeFormat(rs.getString("EVENT_GRADEFORMAT"));
				tf.setEventType(rs.getString("EVENT_TYPE"));
				tf.setEventJustification(rs.getString("EVENT_JUSTIFICATION"));
				tf.setApprovalStatus(rs.getInt("APPROVAL_STATUS"));
				tf.setIsUrgent(rs.getInt("IS_URGENT"));

				forms.add(tf);
			}

			return forms;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateForm(int formId, int approvalStatus) {

		try {

			String sql = "UPDATE tuition_forms SET approval_status = ? WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(approvalStatus));
			ps.setString(2, Integer.toString(formId));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteForm(TuitionForm tf) {

		try {

			String sql = "DELETE tuition_forms WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(tf.getFormId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<TuitionForm> getFormsForSupervisor(int id) {

		List<TuitionForm> forms = new ArrayList<TuitionForm>();

		try {

			String sql = "SELECT * FROM tuition_forms \r\n"
					+ "INNER JOIN employees ON employees.emp_id = tuition_forms.emp_id\r\n"
					+ "WHERE employees.supervisor_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				TuitionForm tf = new TuitionForm();
				tf.setFormId(rs.getInt("FORM_ID"));
				tf.setEmpId(rs.getInt("EMP_ID"));
				tf.setEventDate(rs.getString("EVENT_DATE"));
				tf.setEventTime(rs.getInt("EVENT_TIME"));
				tf.setEventLocation(rs.getString("EVENT_LOCATION"));
				tf.setDescription(rs.getString("EVENT_DESC"));
				tf.setEventCost(rs.getInt("EVENT_COST"));
				tf.setGradeFormat(rs.getString("EVENT_GRADEFORMAT"));
				tf.setEventType(rs.getString("EVENT_TYPE"));
				tf.setEventJustification(rs.getString("EVENT_JUSTIFICATION"));
				tf.setApprovalStatus(rs.getInt("APPROVAL_STATUS"));
				tf.setIsUrgent(rs.getInt("IS_URGENT"));

				forms.add(tf);
			}

			return forms;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<TuitionForm> getFormsForDepartHead(int departmentId) {
		
		List<TuitionForm> forms = new ArrayList<TuitionForm>();

		try {

			String sql = "SELECT * FROM employees INNER JOIN tuition_forms ON tuition_forms.emp_id = employees.emp_id WHERE department_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
					
			ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(departmentId));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				TuitionForm tf = new TuitionForm();
				tf.setFormId(rs.getInt("FORM_ID"));
				tf.setEmpId(rs.getInt("EMP_ID"));
				tf.setEventDate(rs.getString("EVENT_DATE"));
				tf.setEventTime(rs.getInt("EVENT_TIME"));
				tf.setEventLocation(rs.getString("EVENT_LOCATION"));
				tf.setDescription(rs.getString("EVENT_DESC"));
				tf.setEventCost(rs.getInt("EVENT_COST"));
				tf.setGradeFormat(rs.getString("EVENT_GRADEFORMAT"));
				tf.setEventType(rs.getString("EVENT_TYPE"));
				tf.setEventJustification(rs.getString("EVENT_JUSTIFICATION"));
				tf.setApprovalStatus(rs.getInt("APPROVAL_STATUS"));
				tf.setIsUrgent(rs.getInt("IS_URGENT"));

				forms.add(tf);
			}

			return forms;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TuitionForm> getFormsForBenCo() {
		
		List<TuitionForm> forms = new ArrayList<TuitionForm>();

		try {

			String sql = "SELECT * FROM employees INNER JOIN tuition_forms ON tuition_forms.emp_id = employees.emp_id WHERE department_id > 0";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				TuitionForm tf = new TuitionForm();
				tf.setFormId(rs.getInt("FORM_ID"));
				tf.setEmpId(rs.getInt("EMP_ID"));
				tf.setEventDate(rs.getString("EVENT_DATE"));
				tf.setEventTime(rs.getInt("EVENT_TIME"));
				tf.setEventLocation(rs.getString("EVENT_LOCATION"));
				tf.setDescription(rs.getString("EVENT_DESC"));
				tf.setEventCost(rs.getInt("EVENT_COST"));
				tf.setGradeFormat(rs.getString("EVENT_GRADEFORMAT"));
				tf.setEventType(rs.getString("EVENT_TYPE"));
				tf.setEventJustification(rs.getString("EVENT_JUSTIFICATION"));
				tf.setApprovalStatus(rs.getInt("APPROVAL_STATUS"));
				tf.setIsUrgent(rs.getInt("IS_URGENT"));

				forms.add(tf);
			}

			return forms;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<TuitionForm> checkFormApproval() {
		
		
		List<TuitionForm> forms = new ArrayList<TuitionForm>();

		try {

			String sql = "SELECT * FROM tuition_forms\r\n"
					+ "JOIN approvals ON approvals.approval_id = tuition_forms.approval_status\r\n"
					+ "WHERE (approvals.benCo_approval = 1 AND approvals.empSup_approval = 1 AND approvals.departmenthead_approval = 1)";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				TuitionForm tf = new TuitionForm();
				tf.setFormId(rs.getInt("FORM_ID"));
				tf.setEmpId(rs.getInt("EMP_ID"));
				tf.setEventDate(rs.getString("EVENT_DATE"));
				tf.setEventTime(rs.getInt("EVENT_TIME"));
				tf.setEventLocation(rs.getString("EVENT_LOCATION"));
				tf.setDescription(rs.getString("EVENT_DESC"));
				tf.setEventCost(rs.getInt("EVENT_COST"));
				tf.setGradeFormat(rs.getString("EVENT_GRADEFORMAT"));
				tf.setEventType(rs.getString("EVENT_TYPE"));
				tf.setEventJustification(rs.getString("EVENT_JUSTIFICATION"));
				tf.setApprovalStatus(rs.getInt("APPROVAL_STATUS"));
				tf.setIsUrgent(rs.getInt("IS_URGENT"));

				forms.add(tf);
			}

			return forms;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
