package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.TuitionForm;
import com.revature.repositories.TuitionFormRepo;
import com.revature.repositories.TuitionFormRepoImpl;


public class TuitionFormService {

	private TuitionFormRepo tfr = new TuitionFormRepoImpl();
	
	public List<TuitionForm> getFormsByEmpId(int id) {
		return tfr.getFormsByEmpId(id);
	}
	
	public List<TuitionForm> checkFormApproval() {
		return tfr.checkFormApproval();
	}
	
	public int createForm(TuitionForm tf) {
		return tfr.createForm(tf);
	}
	
	public boolean updateForm(int formId, int approvalStatus) {
		return tfr.updateForm(formId, approvalStatus);
	}
	
	public List<TuitionForm> getAllForms(int id) {
		return tfr.getAllForms(id);
	}
	
	public List<TuitionForm> getFormsForSupervisor(int id) {
		return tfr.getFormsForSupervisor(id);
	}
	
	public List<TuitionForm> getFormsForDepartHead(int departmentId) {
		return tfr.getFormsForDepartHead(departmentId);
	}
	
	public List<TuitionForm> getFormsForBenCo() {
		return tfr.getFormsForBenCo();
	}
	
	public boolean deleteForm(TuitionForm tf) {
		return tfr.deleteForm(tf);
	}
	
	
	
	// build out more services
}
