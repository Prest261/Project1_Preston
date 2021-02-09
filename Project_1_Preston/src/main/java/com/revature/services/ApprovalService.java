package com.revature.services;

import java.util.List;

import com.revature.models.Approvals;
import com.revature.models.TuitionForm;
import com.revature.repositories.ApprovalsRepo;
import com.revature.repositories.ApprovalsRepoImpl;

public class ApprovalService {

	ApprovalsRepo ar = new ApprovalsRepoImpl();

	public int createApproval(Approvals approval) {
		return ar.createApproval(approval);
	}

	public Approvals getApprovalById(int id) {
		return ar.getApprovalById(id);
	}

	public List<Approvals> getAllApprovals() {
		return ar.getAllApprovals();
	}

	// Update
	public boolean updateSupervisorApprovals(int approvalId, int supApproval) {
		return ar.updateSupervisorApprovals(approvalId, supApproval);
	}

	public boolean updateDepartmentHeadApprovals(int approvalId, int departHeadApproval) {
		return ar.updateDepartmentHeadApprovals(approvalId, departHeadApproval);
	}

	public boolean updateBenCoApprovals(int approvalId, int benCoApproval) {
		return ar.updateBenCoApprovals(approvalId, benCoApproval);
	}

	// Delete
	boolean deleteApproval(Approvals a) {
		return ar.deleteApproval(a);
	}

}
