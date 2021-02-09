package com.revature.repositories;

import java.util.List;

import com.revature.models.TuitionForm;


public interface TuitionFormRepo {

	// CREATE new form
		public int createForm(TuitionForm tf);
		
		// READ 
		public List<TuitionForm> getFormsByEmpId(int id);
		
		public List<TuitionForm> checkFormApproval();
		
		public List<TuitionForm> getAllForms(int id);
		
		public List<TuitionForm> getFormsForSupervisor(int id);
		
		public List<TuitionForm> getFormsForDepartHead(int departmentId);
		
		public List<TuitionForm> getFormsForBenCo();
		
		// Update
		public boolean updateForm(int formId, int approvalStatus);
		
		// Delete
		boolean deleteForm(TuitionForm tf);

}
