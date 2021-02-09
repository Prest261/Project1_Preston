package com.revature.repositories;

import java.util.List;

import com.revature.models.Approvals;
import com.revature.models.Event;
import com.revature.models.TuitionForm;

public interface ApprovalsRepo {

	// CREATE new approval
		public int createApproval(Approvals approval);
		
		// READ 
		Approvals getApprovalById(int id);
		
		public List<Approvals> getAllApprovals();
		
		public List<Approvals> getAllFullyApprovedApprovals();
		
		// Update
		public boolean updateSupervisorApprovals(int approvalId, int supApproval);
		public boolean updateDepartmentHeadApprovals(int approvalId, int departHeadApproval);
		public boolean updateBenCoApprovals(int approvalId, int benCoApproval);
		
		// Delete
	boolean deleteApproval(Approvals a);
}
