package CustomerIssueResolution.Repository;
import CustomerIssueResolution.model.Agent;

import java.util.*;
public class AgentRepository {
    private final Map<String, Agent> agents = new HashMap<>();

    public void save(Agent agent) {
        agents.put(agent.getId(), agent);
    }

    public Agent findById(String id) {
        return agents.get(id);
    }

    public List<Agent> findAll() {
        return new ArrayList<>(agents.values());
    }
}
