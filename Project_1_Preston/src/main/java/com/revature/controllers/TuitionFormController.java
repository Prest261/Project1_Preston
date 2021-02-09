package com.revature.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.revature.models.Employee;
import com.revature.models.TuitionForm;
import com.revature.services.EmployeeService;
import com.revature.services.TuitionFormService;

public class TuitionFormController {

	public static TuitionFormService tfs = new TuitionFormService();
	public static EmployeeService es = new EmployeeService();
	public static Gson gson = new Gson();

	public static void getFormsByEmpId(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}

		List<TuitionForm> forms = tfs.getAllForms(id);

		response.getWriter().append((forms != null) ? gson.toJson(forms) : "{}");

	}

	public static void createForm(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		TuitionForm tf = gson.fromJson(request.getReader(), TuitionForm.class);

		int formId = tfs.createForm(tf);
		tf.setFormId(formId);

		response.getWriter().append((formId > 0) ? gson.toJson(tf) : "{}");
	}

	public static void updateForm(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		TuitionForm tf = gson.fromJson(request.getReader(), TuitionForm.class);

		tfs.updateForm(tf.getFormId(), tf.getApprovalStatus());

		boolean success = tf.getApprovalStatus() > 0;

		response.getWriter().append((success) ? gson.toJson(tf) : "{}");
	}

	public static void getAllForms(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}

		List<TuitionForm> forms = tfs.getAllForms(id);

		response.getWriter().append((forms != null) ? gson.toJson(forms) : "{}");
	}

	public static void getFormsForSupervisor(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}

		List<TuitionForm> forms = tfs.getFormsForSupervisor(id);

		response.getWriter().append((forms != null) ? gson.toJson(forms) : "{}");
	}

	public static void getFormsForDepartHead(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		String input = request.getParameter("id");

		int departmentId;
		try {
			departmentId = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted");
			return;
		}

		List<TuitionForm> forms = tfs.getFormsForDepartHead(departmentId);

		response.getWriter().append((forms != null) ? gson.toJson(forms) : "{}");

	}

	public static void getFormsForBenCo(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		List<TuitionForm> forms = tfs.getFormsForBenCo();
		System.out.println(forms);

		response.getWriter().append((forms != null) ? gson.toJson(forms) : "{}");

	}

	public static void checkFormApproval(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		List<TuitionForm> forms = tfs.checkFormApproval();
		System.out.println(forms);
		
		for(int i = 0; i < forms.size(); i++) {
//		HashMap<String, Integer> ramt = new HashMap<String, Integer>();
//			ramt.put("University Course", );
//			ramt.put("Seminar", (int)0.60);
//			ramt.put("Certification Preparation Class", (int)0.75);
//			ramt.put("Certification", (int)1.00);
//			ramt.put("Technical Training", (int)0.90);
//			ramt.put("Other", (int)0.30);
			Employee emp = es.getEmployeeById(forms.get(i).getEmpId());
			System.out.println("getting emp " + emp);
			String eventType = forms.get(i).getEventType();
			//int typeAmount = get(eventType);
			
			if(emp.getTuitionStatus() > forms.get(i).getEventCost()) {
				
				int tuitionStatus = emp.setTuitionStatus(emp.getTuitionStatus() - (forms.get(i).getEventCost()));
				es.updateEmployee(emp, tuitionStatus);
			}
		}
		System.out.println("printing forms again" + forms);
		response.getWriter().append((forms != null) ? gson.toJson(forms) : "{}");

	}

	public static void deleteForm(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

	}

}
