Project Description

The project is an Event Management System API that allows users to add, retrieve, update, and delete events. The system is designed to provide functionalities for managing various events such as conferences, workshops, parties, etc.

Key Features:

Add Event: Users can add new events by providing details such as event name, city name, date, time, latitude, and longitude.

Get Events: Users can retrieve a list of events based on their location and optionally filter by date range.


Technology Stack:

Programming Language: Java
Framework: Spring Boot
Database: PostgreSQL
API Documentation: Swagger
HTTP Client: RestTemplate
Design Decisions:

Spring Boot: Chosen for its simplicity in setting up RESTful APIs, dependency injection, and handling various aspects of application development.

PostgreSQL: Selected for its reliability, scalability, and support for complex queries. It also integrates well with Spring Boot using Spring Data JPA.

Swagger: Used for API documentation to provide clear and interactive documentation for developers.

RestTemplate: Utilized for making HTTP requests to external APIs for fetching weather data.
