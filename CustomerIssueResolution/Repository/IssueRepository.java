package CustomerIssueResolution.Repository;
import CustomerIssueResolution.model.Issue;
import java.util.*;
public class IssueRepository {
    private final Map<String, Issue> issues = new HashMap<>();

    public void save(Issue issue) {
        issues.put(issue.getId(), issue);
    }

    public Issue findById(String id) {
        return issues.get(id);
    }

    public List<Issue> findAll() {
        return new ArrayList<>(issues.values());
    }
}