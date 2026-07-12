# Issue Management System

## Overview

This project implements a simple **Issue Management System** that allows customers to raise issues, assign them to support agents, track issue status, and maintain agent work history.

The implementation supports issue creation, assignment based on agent expertise and availability, filtering issues, updating/resolving issues, and viewing the work history of agents.

---

## Requirements

Implement the following functions (listed in decreasing order of importance):

1. `createIssue(transactionId, issueType, subject, description, email)`
2. `addAgent(agentEmail, agentName, List<IssueType>)`
3. `assignIssue(issueId)`
   - Assign the issue to any available (free) agent who supports the issue type.
   - If no suitable agent is available, place the issue in the agent's waitlist.
4. `getIssues(filter)`
   - Return all issues matching the provided filter.
5. `updateIssue(issueId, status, resolution)`
6. `resolveIssue(issueId, resolution)`
7. `viewAgentsWorkHistory()`
   - Return the list of issues handled by each agent.

---

## Features

- Create customer issues
- Register support agents with supported issue categories
- Assign issues based on:
  - Supported issue type
  - Agent availability
- Waitlist support when agents are busy
- Filter issues by fields such as:
  - Customer email
  - Issue type
  - Status
- Update issue status and resolution
- Resolve issues
- View agent work history

---

## Assumptions

- Each issue has a unique Issue ID.
- Agents can handle only one active issue at a time.
- If all eligible agents are busy, the issue is added to the waitlist.
- When an agent becomes free, the next waiting issue can be assigned.
- Newly created issues have status **Open**.

---

## API

### 1. Create Issue

```java
createIssue(transactionId, issueType, subject, description, email)
```

Creates a new issue.

---

### 2. Add Agent

```java
addAgent(agentEmail, agentName, List<IssueType>)
```

Registers a support agent along with the issue types they can handle.

---

### 3. Assign Issue

```java
assignIssue(issueId)
```

Assigns an issue to an available agent.

Assignment strategy:

- Find agents supporting the issue type.
- Assign to any free agent.
- If no agent is free, add the issue to the waitlist.

---

### 4. Get Issues

```java
getIssues(filter)
```

Returns all issues matching the provided filter.

Example filters:

- Email
- Issue Type
- Status

---

### 5. Update Issue

```java
updateIssue(issueId, status, resolution)
```

Updates the issue status and optionally its resolution.

---

### 6. Resolve Issue

```java
resolveIssue(issueId, resolution)
```

Marks the issue as resolved and stores the resolution.

---

### 7. View Agent Work History

```java
viewAgentsWorkHistory()
```

Displays the list of issues worked on by each agent.

---

# Sample Test Cases

## Create Issues

```java
createIssue(
    "T1",
    "Payment Related",
    "Payment Failed",
    "My payment failed but money is debited",
    "testUser1@test.com"
);
```

**Output**

```
Issue I1 created against transaction "T1"
```

---

```java
createIssue(
    "T2",
    "Mutual Fund Related",
    "Purchase Failed",
    "Unable to purchase Mutual Fund",
    "testUser2@test.com"
);
```

**Output**

```
Issue I2 created against transaction "T2"
```

---

```java
createIssue(
    "T3",
    "Payment Related",
    "Payment Failed",
    "My payment failed but money is debited",
    "testUser2@test.com"
);
```

**Output**

```
Issue I3 created against transaction "T3"
```

---

## Add Agents

```java
addAgent(
    "agent1@test.com",
    "Agent 1",
    Arrays.asList("Payment Related", "Gold Related")
);
```

**Output**

```
Agent A1 created
```

---

```java
addAgent(
    "agent2@test.com",
    "Agent 2",
    Arrays.asList("Payment Related")
);
```

**Output**

```
Agent A2 created
```

---

## Assign Issues

```java
assignIssue("I1");
```

**Output**

```
Issue I1 assigned to Agent A1
```

---

```java
assignIssue("I2");
```

**Output**

```
Issue I2 assigned to Agent A2
```

---

```java
assignIssue("I3");
```

**Output**

```
Issue I3 added to waitlist of Agent A1
```

---

## Get Issues

### Filter by Email

```java
getIssues({"email":"testUser2@test.com"});
```

**Output**

```
I2 {
  "T2",
  "Mutual Fund Related",
  "Purchase Failed",
  "Unable to purchase Mutual Fund",
  "testUser2@test.com",
  "Open"
}

I3 {
  "T3",
  "Payment Related",
  "Payment Failed",
  "My payment failed but money is debited",
  "testUser2@test.com",
  "Open"
}
```

---

### Filter by Issue Type

```java
getIssues({"type":"Payment Related"});
```

**Output**

```
I1 {
  "T1",
  "Payment Related",
  "Payment Failed",
  "My payment failed but money is debited",
  "testUser1@test.com",
  "Open"
}

I3 {
  "T3",
  "Payment Related",
  "Payment Failed",
  "My payment failed but money is debited",
  "testUser2@test.com",
  "Open"
}
```

---

## Update Issue

```java
updateIssue(
    "I1",
    "In Progress",
    null
);
```

**Output**

```
Issue I1 updated successfully.
```

---

## Resolve Issue

```java
resolveIssue(
    "I1",
    "Payment reversed successfully."
);
```

**Output**

```
Issue I1 resolved successfully.
```

---

## View Agent Work History

```java
viewAgentsWorkHistory();
```

**Sample Output**

```
Agent A1
---------
I1
I3

Agent A2
---------
I2
```

---

# Data Model

## Issue

| Field | Description |
|--------|-------------|
| Issue ID | Unique identifier |
| Transaction ID | Associated transaction |
| Issue Type | Category of issue |
| Subject | Short title |
| Description | Detailed description |
| Customer Email | Customer email |
| Status | Open / In Progress / Resolved |
| Resolution | Resolution text |
| Assigned Agent | Agent handling the issue |

---

## Agent

| Field | Description |
|--------|-------------|
| Agent ID | Unique identifier |
| Name | Agent name |
| Email | Agent email |
| Supported Issue Types | Categories the agent can resolve |
| Current Status | Free / Busy |
| Assigned Issues | Active and historical issues |
| Waitlist | Pending issues awaiting assignment |

---

# Assignment Strategy

1. Find all agents supporting the issue type.
2. Select any available (free) agent.
3. Assign the issue.
4. If no suitable agent is available, add the issue to the waitlist.
5. When an agent becomes available, assign the next waiting issue.

---

# Possible Enhancements

- Round-robin assignment strategy
- Least-loaded agent assignment
- Priority-based issue handling
- SLA tracking
- Agent availability scheduling
- Notifications (Email/SMS)
- Audit logs
- Persistent database support
- REST API integration
- Dashboard for issue monitoring