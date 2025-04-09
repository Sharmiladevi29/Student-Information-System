package insurance;

import insurance.dao.IPolicyService;
import insurance.dao.InsuranceServiceImpl;
import myexceptions.PolicyNotFoundException;

import java.sql.Connection;
import java.util.Collection;

public class Main {
	public static void main(String[] args) {

		IPolicyService policyService = new InsuranceServiceImpl();

// Creating the policies
		Policy policy1 = new Policy(1, "Life Secure", "Secure life insurance");
		Policy policy2 = new Policy(2, "Health Guard", "Covers major health risks");

		policyService.createPolicy(policy1);
		policyService.createPolicy(policy2);

// Getting all policies
		System.out.println("All Policies:");
		Collection<Policy> allPolicies = policyService.getAllPolicies();
		for (Policy p : allPolicies) {
			System.out.println(p);
		}

// Fetching the policy
		try {
			Policy policy = policyService.getPolicy(1);
			System.out.println("Fetched Policy:");
			System.out.println(policy);
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
		}

// Update policy
		Policy updatedPolicy = new Policy(1, "Life Secure Plus", "Updated life insurance with benefits");
		boolean updateStatus = policyService.updatePolicy(updatedPolicy);
		if (updateStatus) {
			System.out.println("Policy updated successfully.");
		} else {
			System.out.println("Failed to update policy.");
		}

// Delete policy
		try {
			boolean deleteStatus = policyService.deletePolicy(2);
			if (deleteStatus) {
				System.out.println("Policy deleted successfully.");
			} else {
				System.out.println("Failed to delete policy.");
			}
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
		}

// Retrieve the Final list of policy...
		System.out.println("Final list of policies:");
		for (Policy p : policyService.getAllPolicies()) {
			System.out.println(p);
		}

		Connection con = DBconnection.getConnection();
		if (con != null) {
			System.out.println("Connected successfully to database!");
		} else {
			System.out.println("Connection failed.");
		}
	}
	}
