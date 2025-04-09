package insurance.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import insurance.Policy;
import myexceptions.PolicyNotFoundException;

public class InsuranceServiceImpl implements IPolicyService {

	private Map<Integer, Policy> policyMap = new HashMap<>();

	@Override
	public boolean createPolicy(Policy policy) {
		if (!policyMap.containsKey(policy.getPolicyId())) {
			policyMap.put(policy.getPolicyId(), policy);
			return true;
		}
		return false;
	}

	@Override
	public Policy getPolicy(int policyId) throws PolicyNotFoundException {
		if (!policyMap.containsKey(policyId)) {
			throw new PolicyNotFoundException("Policy ID " + policyId + " not found.");
		}
		return policyMap.get(policyId);
	}

	@Override
	public Collection<Policy> getAllPolicies() {
		return new ArrayList<>(policyMap.values());
	}

	@Override
	public boolean updatePolicy(Policy policy) {
		if (policyMap.containsKey(policy.getPolicyId())) {
			policyMap.put(policy.getPolicyId(), policy);
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePolicy(int policyId) throws PolicyNotFoundException {
		if (!policyMap.containsKey(policyId)) {
			throw new PolicyNotFoundException("Policy ID " + policyId + " not found.");
		}
		policyMap.remove(policyId);
		return true;
	}
}
