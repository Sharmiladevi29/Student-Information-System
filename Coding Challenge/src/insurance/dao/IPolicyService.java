package insurance.dao;

import java.util.Collection;
import insurance.Policy;
import myexceptions.PolicyNotFoundException;

public interface IPolicyService {

// To Create a new policy
	boolean createPolicy(Policy policy);

// To Get a policy by ID
	Policy getPolicy(int policyId) throws PolicyNotFoundException;

// To Get all policies
	Collection<Policy> getAllPolicies();

// To Update an existing policy
	boolean updatePolicy(Policy policy);

// To Delete a policy by ID
	boolean deletePolicy(int policyId) throws PolicyNotFoundException;
}
