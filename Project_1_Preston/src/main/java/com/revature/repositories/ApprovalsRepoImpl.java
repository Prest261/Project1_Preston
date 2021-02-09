package com.revature.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Approvals;
import com.revature.models.Event;
import com.revature.models.TuitionForm;
import com.revature.util.JDBCConnection;

import oracle.jdbc.OracleTypes;

public class ApprovalsRepoImpl implements ApprovalsRepo {

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public int createApproval(Approvals approval) {
		System.out.println(approval);

		try {

			String sql = "CALL add_approval(?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setString(1, Integer.toString(approval.getEventId()));
			cs.setString(2, Integer.toString(approval.getSupervisorApproval()));
			cs.setString(3, Integer.toString(approval.getDepartmentHeadApproval()));
			cs.setString(4, Integer.toString(approval.getBenCoApproval()));
			
			cs.registerOutParameter(5, OracleTypes.NUMBER);
			
			cs.execute();
			int approvalId = cs.getInt(5);
			System.out.println(approvalId);
			
			return approvalId;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Approvals getApprovalById(int id) {

		try {

			String sql = "SELECT * FROM approvals WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Approvals a = new Approvals();
				a.setApprovalId(rs.getInt("APPROVAL_ID"));
				a.setEventId(rs.getInt("EVENT_ID"));
				a.setSupervisorApproval(rs.getInt("EMPSUP_APPROVAL"));
				a.setDepartmentHeadApproval(rs.getInt("DEPARTMENTHEAD_APPROVAL"));
				a.setBenCoApproval(rs.getInt("BENCO_APPROVAL"));

				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Approvals> getAllApprovals() {

		List<Approvals> approvals = new ArrayList<Approvals>();

		try {

			String sql = "SELECT * FROM approvals";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Approvals a = new Approvals();
				a.setApprovalId(rs.getInt("APPROVAL_ID"));
				a.setEventId(rs.getInt("EVENT_ID"));
				a.setSupervisorApproval(rs.getInt("EMPSUP_APPROVAL"));
				a.setDepartmentHeadApproval(rs.getInt("DEPARTMENTHEAD_APPROVAL"));
				a.setBenCoApproval(rs.getInt("BENCO_APPROVAL"));

				approvals.add(a);
			}

			return approvals;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean deleteApproval(Approvals a) {

		try {

			String sql = "DELETE approvals WHERE approval_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(a.getApprovalId()));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateSupervisorApprovals(int approvalId, int supApproval) {

		try {

			String sql = "UPDATE approvals SET empSup_approval = ? WHERE approval_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(supApproval));
			ps.setString(2, Integer.toString(approvalId));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateDepartmentHeadApprovals(int approvalId, int departHeadApproval) {

		try {

			String sql = "UPDATE approvals SET departmentHead_approval = ? WHERE approval_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(departHeadApproval));
			ps.setString(2, Integer.toString(approvalId));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateBenCoApprovals(int approvalId, int benCoApproval) {

		try {

			String sql = "UPDATE approvals SET benCo_approval = ? WHERE approval_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(benCoApproval));
			ps.setString(2, Integer.toString(approvalId));

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Approvals> getAllFullyApprovedApprovals() {
		
		List<Approvals> approvals = new ArrayList<Approvals>();

		try {

			String sql = "SELECT * FROM approvals WHERE benCo_approval =1 AND empSup_approval =1 AND departmentHead_approval = 1";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Approvals a = new Approvals();
				a.setApprovalId(rs.getInt("APPROVAL_ID"));
				a.setEventId(rs.getInt("EVENT_ID"));
				a.setSupervisorApproval(rs.getInt("EMPSUP_APPROVAL"));
				a.setDepartmentHeadApproval(rs.getInt("DEPARTMENTHEAD_APPROVAL"));
				a.setBenCoApproval(rs.getInt("BENCO_APPROVAL"));

				approvals.add(a);
			}

			return approvals;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
