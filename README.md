# Computer Shop Inventory Management System

A Spring Boot inventory management application for managing computer parts and PC products.  
Built to demonstrate backend validation, persistence, testing, and a clean MVC architecture.

---

## Features
- Add, update, and delete **Inhouse** and **Outsourced** parts
- Track inventory with **minimum and maximum constraints**
- Create products composed of multiple parts
- Prevent invalid inventory updates using **custom validation**
- “Buy Now” functionality to safely decrement product inventory
- Persistent storage using an **H2 file-based database**
- Clean UI built with **Thymeleaf + Bootstrap**

---

## Tech Stack
- Java
- Spring Boot (MVC, Data JPA)
- Hibernate Validation
- Thymeleaf
- Bootstrap
- H2 Database
- JUnit 5

---

## Testing
- Unit tests validate minimum and maximum inventory rules for parts
- Ensures invalid inventory states cannot be saved

---

## Running the App
1. Clone the repository  
2. Run the Spring Boot application  
3. Open:

