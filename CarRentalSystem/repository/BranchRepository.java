package CarRentalSystem.repository;
import CarRentalSystem.model.Branch;
import java.util.*;
public class BranchRepository {
    private final Map<String, Branch> branches;
    public BranchRepository() {
        this.branches = new HashMap<>();
    }
    public void addBranch(Branch branch) {
        branches.put(branch.getId(), branch);
    }
    public Branch getBranchById(String branchId) {
        return branches.getOrDefault(branchId, null);
    }
    public void removeBranch(String branchId) {
        branches.remove(branchId);
    }
    public List<Branch> getAllBranches() {
        return new ArrayList<>(branches.values());
    }

}
