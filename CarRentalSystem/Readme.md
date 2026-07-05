# Requirements

## Extensibility

### 1. Vehicle Types
The system should support extensible vehicle types, such as:
- Sedan
- Hatchback
- SUV
- Any future vehicle categories

### 2. Vehicle Selection Strategy
When multiple vehicles are available, the booking system should support different selection strategies, including:
- Cheapest First
- Least Booked
- Additional pluggable strategies in the future

### 3. Rental Pricing Strategy
The system should support multiple rental charge calculation strategies, such as:
- Hourly Pricing
- Distance-Based Pricing
- Easily extensible for future pricing models

### 4. Payment Methods
The payment module should be extensible to support multiple payment methods, including:
- UPI
- Credit Card
- Cash
- Additional payment methods in the future

---

## Dynamic Behavior

### 1. Branch Management
The system should allow dynamic management of branches, including:
- Add Branch
- Update Branch
- Delete Branch

Vehicle management should also support:
- Add Vehicle
- Update Vehicle
- Delete Vehicle

### 2. Branch-Specific Inventory
Each branch should maintain its own vehicle inventory. Every vehicle must be registered under a specific branch.

---

## High Traffic / Concurrency

### Vehicle Booking Synchronization
The system must ensure that the same vehicle cannot be booked simultaneously by multiple users.

To achieve this, the booking workflow should use appropriate concurrency control mechanisms, such as:
- Locking
- Synchronization
- Atomic reservation logic