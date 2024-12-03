Golf Club Tournament Management Application
A Spring Boot application for managing golf club members and tournaments. Fully Dockerized with support for CRUD operations and member-tournament linking.

Features
Members:

Manage member info: name, email, phone, address, start date, duration, and membership type (Gold, Silver, Bronze).
Endpoints: GET, POST, PUT, DELETE under /api/members.

Tournaments:

Manage tournament details: name, location, date.
Endpoints: GET, POST, PUT, DELETE under /api/tournaments.
Member-Tournament Linking:

Add members to tournaments: /api/tournaments/{id}/members.
Retrieve tournament members: /api/tournaments/{id}/members.

Dockerized:

Easily deployable with Docker.

How to Run
Build with Docker:

1. bash

docker build -t golf-tournament-app .
docker run -p 8080:8080 golf-tournament-app

2.Access API:

Base URL: http://localhost:8080/api

3. Database:

MySQL is pre-configured with default credentials in application.properties.

Testing with Postman

  1. Set Content-Type to application/json.
  2. Example POST /api/members body:

  {
    "name": "John Doe",
    "address": "123 Main Street",
    "email": "john.doe@example.com",
    "phone": "123-456-7890",
    "startDate": "2024-01-01",
    "duration": 12,
    "membershipType": "Gold"
  }
