# Requirements

## Extensible

### 1. What types of vehicles should the system support?
- The system should be extensible to support different vehicle types such as:
  - Bike
  - Car
  - Truck
  - Bus
  - etc.

### 2. Can a parking spot accommodate any vehicle type?
- No. Each parking spot supports a specific vehicle type.

### 3. How should parking prices be calculated?
The system should support multiple pricing strategies, including:
- **Time-based pricing**
  - Peak hours
  - Non-peak hours
- **Event-based pricing**
  - Concerts
  - Weekends
  - Festivals
  - etc.

### 4. Should the system support multiple payment methods?
- Yes. The system should be extensible to accommodate multiple payment methods such as:
  - UPI
  - Credit Card
  - Debit Card
  - Cash
  - etc.

---

## Dynamic

### 1. How many floors and parking slots can the parking lot have?
- The system should allow dynamic configuration of:
  - Number of floors
  - Number of parking slots per floor
- Each parking slot must be mapped to a specific vehicle type.

### 2. How many gates should the system support?
- The system should support multiple entry and exit gates.
- A parking ticket should be generated at the entry gate containing:
  - Vehicle details
  - Entry timestamp
  - Assigned parking slot
  - Ticket ID
- At the exit gate, the ticket will be used to calculate the final parking fee.

---

## Concurrency

### 1. Are we building a system for a single parking lot or multiple parking lots?
- Initially, the system will support a **single physical parking lot**.

### 2. Should we ensure that no two vehicles receive the same parking spot?
- Yes.
- The system should use proper locking mechanisms or synchronized access to ensure that a parking spot cannot be assigned to multiple vehicles simultaneously.
