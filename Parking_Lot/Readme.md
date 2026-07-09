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





classDiagram
    %% ===== Enums =====
    class VehicleType {
        <<enumeration>>
        CAR
        BIKE
        TRUCK
    }
    class GateType {
        <<enumeration>>
        ENTRY
        EXIT
    }
    class PaymentMode {
        <<enumeration>>
        CASH
        UPI
        CARD
    }
    class PaymentStatus {
        <<enumeration>>
        PENDING
        SUCCESS
        FAILED
    }
    class PricingStrategyType {
        <<enumeration>>
        TIME_BASED
        EVENT_BASED
    }

    %% ===== Vehicle hierarchy =====
    class Vehicle {
        <<abstract>>
        -String number
        -VehicleType type
    }
    class Car {
        +Car(number)
    }
    class Bike {
        +Bike(number)
    }
    class Truck {
        +Truck(number)
    }
    Vehicle <|-- Car
    Vehicle <|-- Bike
    Vehicle <|-- Truck
    Vehicle --> VehicleType

    %% ===== Gate hierarchy =====
    class Gate {
        <<abstract>>
        #String id
        +getType() GateType
    }
    class EntryGate {
        +EntryGate(id)
        +getType() GateType
        +parkVehicle(vehicle, entryTime) Ticket
    }
    class ExitGate {
        +ExitGate(id)
        +getType() GateType
        +unparkVehicle(ticketId, exitTime, paymentMode) void
    }
    Gate <|-- EntryGate
    Gate <|-- ExitGate
    Gate --> GateType

    %% ===== Parking structure =====
    class ParkingSpot {
        -String id
        -VehicleType allowedType
        -AtomicBoolean occupied
        +tryOccupy() boolean
        +vacate() void
        +isOccupied() boolean
    }
    class ParkingFloor {
        -String id
        -Map~String,ParkingSpot~ spots
        +addSpot(spot) void
        +findAvailableSpot(vehicleType) ParkingSpot
    }
    ParkingFloor "1" o-- "many" ParkingSpot : spots
    ParkingSpot --> VehicleType

    %% ===== Ticket =====
    class Ticket {
        -String ticketId
        -LocalDateTime entryTime
        -Vehicle vehicle
        -String floorId
        -String spotId
        -PaymentStatus paymentStatus
    }
    Ticket --> Vehicle
    Ticket --> PaymentStatus

    %% ===== Pricing strategy =====
    class PricingStrategy {
        <<interface>>
        +calculateFee(type, entryTime, exitTime) double
    }
    class TimeBasedPricing {
        -LocalTime PEAK_START
        -LocalTime PEAK_END
        -isPeak(time) boolean
        +calculateFee(type, entryTime, exitTime) double
    }
    class EventBasedPricing {
        -Map~VehicleType,Double~ EVENT_HOURLY_RATES
        +calculateFee(type, entryTime, exitTime) double
    }
    PricingStrategy <|.. TimeBasedPricing
    PricingStrategy <|.. EventBasedPricing

    %% ===== Payment strategy =====
    class PaymentStrategy {
        <<interface>>
        +processPayment(ticket, amount) boolean
    }
    class CashPayment {
        +processPayment(ticket, amount) boolean
    }
    class UpiPayment {
        +processPayment(ticket, amount) boolean
    }
    class CardPayment {
        +processPayment(ticket, amount) boolean
    }
    PaymentStrategy <|.. CashPayment
    PaymentStrategy <|.. UpiPayment
    PaymentStrategy <|.. CardPayment

    %% ===== Factories =====
    class VehicleFactory {
        <<factory>>
        +create(number, type)$ Vehicle
    }
    class PaymentStrategyFactory {
        <<factory>>
        +get(mode)$ PaymentStrategy
    }
    class PricingStrategyFactory {
        <<factory>>
        +get(type)$ PricingStrategy
    }
    VehicleFactory ..> Vehicle : creates
    VehicleFactory ..> Car : creates
    VehicleFactory ..> Bike : creates
    VehicleFactory ..> Truck : creates
    PaymentStrategyFactory ..> PaymentStrategy : creates
    PricingStrategyFactory ..> PricingStrategy : creates

    %% ===== Services =====
    class PaymentProcessor {
        -PaymentStrategy strategy
        +PaymentProcessor(strategy)
        +pay(ticket, amount) boolean
    }
    PaymentProcessor --> PaymentStrategy : uses
    PaymentProcessor ..> Ticket

    class ParkingLot {
        <<singleton>>
        -ParkingLot INSTANCE$
        -Map~String,ParkingFloor~ floors
        -Map~String,Ticket~ activeTickets
        -PricingStrategy pricingStrategy
        +getInstance()$ ParkingLot
        +addFloor(floor) void
        +parkVehicle(vehicle, entryTime) Ticket
        +unparkVehicle(ticketId, exitTime, paymentMode) void
        +printStatus() void
    }
    ParkingLot "1" o-- "many" ParkingFloor : floors
    ParkingLot "1" o-- "many" Ticket : activeTickets
    ParkingLot --> PricingStrategy : uses
    ParkingLot ..> PaymentStrategyFactory : uses
    ParkingLot ..> PaymentProcessor : creates

    EntryGate ..> ParkingLot : delegates to
    ExitGate ..> ParkingLot : delegates to

    %% ===== Utils =====
    class DateTimeParser {
        <<utility>>
        +parse(input)$ LocalDateTime
    }