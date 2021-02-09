package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.revature.models.Approvals;
import com.revature.models.Event;
import com.revature.services.ApprovalService;


public class ApprovalController {

	public static ApprovalService as = new ApprovalService();
	public static Gson gson = new Gson();
	
	
public static void getApprovalById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}
		
		Approvals a = as.getApprovalById(id);
		
		response.getWriter().append((a != null) ? gson.toJson(a) : "{}");
		
	}
	 
	public static void createApproval(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
		Approvals a = gson.fromJson(request.getReader(), Approvals.class);

		int approvalId = as.createApproval(a);
		a.setApprovalId(approvalId);
		
		response.getWriter().append((approvalId > 0)  ? gson.toJson(a) : "{}");
	}
	

//	public List<Approvals> getAllApprovals() {
//		return ar.getAllApprovals();
//	}

	// Update
	public static void updateSupervisorApprovals(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {

		Approvals a = gson.fromJson(request.getReader(), Approvals.class);

		as.updateSupervisorApprovals(a.getApprovalId(), a.getSupervisorApproval());

		boolean success = a.getSupervisorApproval() > 0;

		response.getWriter().append((success) ? gson.toJson(a) : "{}");
	}

	public static void updateDepartmentHeadApprovals(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
		Approvals a = gson.fromJson(request.getReader(), Approvals.class);

		as.updateDepartmentHeadApprovals(a.getApprovalId(), a.getDepartmentHeadApproval());

		boolean success = a.getDepartmentHeadApproval() > 0;

		response.getWriter().append((success) ? gson.toJson(a) : "{}");
	}

	public static void updateBenCoApprovals(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
		Approvals a = gson.fromJson(request.getReader(), Approvals.class);

		as.updateBenCoApprovals(a.getApprovalId(), a.getBenCoApproval());

		boolean success = a.getBenCoApproval() > 0;

		response.getWriter().append((success) ? gson.toJson(a) : "{}");
		
	}

	public static void deleteApproval(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
	}

	
}
