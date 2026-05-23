# RFID Backend System

This started as a university project but turned into something I genuinely learned a lot from. The idea was to build a solid backend for an RFID-based access control system — handling card registration, logging entries and exits, and exposing a clean REST API for whatever frontend or hardware needed to talk to it.

I used Java and Spring Boot mainly because I wanted to get comfortable with enterprise-style backend development outside of Python. The access logging part ended up being the most interesting problem — structuring audit trails in a way that was actually useful and queryable took more thought than I expected.

---

## What it does

- Register and manage RFID cards
- Log access events in real time with timestamps and user context
- REST API for integration with frontend dashboards or physical RFID readers
- Role-based permissions (admin vs standard user)
- MySQL for persistence

---

## Stack

- Java 17
- Spring Boot 3
- Spring Security
- MySQL
- Maven

---

## Running locally

Clone the repo and update `src/main/resources/application.properties` with your database details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rfid_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

Then:

```bash
mvn clean install
mvn spring-boot:run
```

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/cards` | List all registered cards |
| POST | `/api/cards/register` | Add a new card |
| GET | `/api/access/logs` | Pull access history |
| POST | `/api/access/verify` | Check card access rights |
| DELETE | `/api/cards/{id}` | Remove a card |

---

## Tests

```bash
mvn test
```

---

There is a related frontend repo ([RFID-PROJECT](https://github.com/balusi130/RFID-PROJECT)) if you want to see the full picture.