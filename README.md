# Read_Cycle_Order_Placed
📚 ReadCycle Inventory Service – Kafka-Based Event-Driven Book Reservation System This microservice handles book inventory and reservation workflows using Apache Kafka as the backbone for event-driven communication. It is part of the ReadCycle ecosystem, enabling seamless book order placement, reservation, and inventory management.

🔧 Features
📦 Book Inventory Management
🔄 Event-Driven Reservation Workflow
✅ Kafka Producer & Consumer Integration
🧮 Oracle DB for Persistent Inventory
🛠️ Built with Spring Boot, Spring Kafka, JPA, and Oracle SQL

📌 Event Flow
ORDER_PLACED event triggers reservation
BOOK_RESERVED or BOOK_RESERVATION_FAILED event is emitted
Reservation state is persisted and auditable
Inventory is decremented after final order confirmation

🧪 Tech Stack
Java 17 + Spring Boot
Apache Kafka
Oracle Database
Spring Data JPA
