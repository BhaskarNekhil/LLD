package CustomerIssueResolution.model;

import java.util.List;
import CustomerIssueResolution.enums.IssueStatus;
import CustomerIssueResolution.enums.IssueType;
import java.util.*;

public class Agent {

    private final String id;
    private final String email;
    private final String name;
    private final Set<IssueType> expertise;

    private String assignedIssueId;
    private final Queue<String> waitList = new LinkedList<>();
    private final List<String> history = new ArrayList<>();

    // Constructor (equivalent to @RequiredArgsConstructor)
    public Agent(String id, String email, String name, Set<IssueType> expertise) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.expertise = expertise;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Set<IssueType> getExpertise() {
        return expertise;
    }

    public String getAssignedIssueId() {
        return assignedIssueId;
    }

    public Queue<String> getWaitList() {
        return waitList;
    }

    public List<String> getHistory() {
        return history;
    }

    // Setter (only for non-final field)
    public void setAssignedIssueId(String assignedIssueId) {
        this.assignedIssueId = assignedIssueId;
    }

    public boolean isAvailable() {
        return assignedIssueId == null;
    }
}