package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ApprovalController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.EventController;
import com.revature.controllers.TuitionFormController;

public class RequestHelper {

	
public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		switch (uri) {
		case "/Project_1_Preston/login.do" : {
			EmployeeController.login(request, response);
			break;
		}
		case "/Project_1_Preston/loggedInUser.do" : {
			EmployeeController.loggedInUser(request, response);
			break;
		}
		case "/Project_1_Preston/getFormsByEmpId.do" : {
			TuitionFormController.getFormsByEmpId(request, response);
			break;
		} 
		case "/Project_1_Preston/createForm.do": {
			TuitionFormController.createForm(request, response);
			break;
		}
		case "/Project_1_Preston/createEvent.do": {
			EventController.createEvent(request, response);
			break;
		}
		case "/Project_1_Preston/createApproval.do": {
			ApprovalController.createApproval(request, response);
			break;
		}
		case "/Project_1_Preston/updateApprovalIdTF.do": {
			TuitionFormController.updateForm(request, response);
			break;
		}
		case "/Project_1_Preston/getAllForms.do": {
			TuitionFormController.getAllForms(request, response);
			break;
		}
		case "/Project_1_Preston/UpdateEventGrade.do": {
			EventController.updateEvent(request, response);
			break;
		}
		case "/Project_1_Preston/getFormsBySupervisorId.do": {
			TuitionFormController.getFormsForSupervisor(request, response);
			break;
		}
		case "/Project_1_Preston/getFormsByDepartmentHeadId.do": {
			TuitionFormController.getFormsForDepartHead(request, response);
			break;
		}
		case "/Project_1_Preston/getFormsByBenCoId.do": {
			TuitionFormController.getFormsForBenCo(request, response);
			break;
		}
		case "/Project_1_Preston/updateSupervisorApproval.do": {
			ApprovalController.updateSupervisorApprovals(request, response);
			break;
		}
		case "/Project_1_Preston/updateDepartmentHeadApproval.do": {
			ApprovalController.updateDepartmentHeadApprovals(request, response);
			break;
		}
		case "/Project_1_Preston/updateBencoHeadApproval.do": {
			ApprovalController.updateBenCoApprovals(request, response);
			break;
		}
		case "/Project_1_Preston/checkFormApproval.do": {
			TuitionFormController.checkFormApproval(request, response);
			break;
		}
		case "/Project_1_Preston/updateTuitionStatus.do": {
			//TuitionFormController
			break;
		}
		case "/Project_1_Preston/logout.do": {
			EmployeeController.logout(request, response);
			break;
		}
		
		default: {
			response.sendError(418, "Default case hit. Cannot brew coffee, its a teapot");
			break;
		}
		}
		
}
}
