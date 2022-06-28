# Spring REST
Let's start to tune our Hibernate project with Spring.

Create controllers:
- CinemaHallController
    - Add cinema hall - POST: /cinema-halls
    - Get all cinema halls - GET: /cinema-halls
- MovieController
    - Add a movieId - POST: /movies 
    - Get all movies - GET: /movies
- MovieSessionController
    - Add movieId session - POST: /movieId-sessions
    - Get all available movieId sessions - GET: /movieId-sessions/available?movieId=1&date=29.02.2020
    - Update movieId session - PUT /movieId-sessions/{id}
    - Remove movieId session - DELETE /movieId-sessions/{id}
- Expecting to see the DTO objects for request and response in the controllers
- If some DAO or service methods are absent - implement them.

Hints:
1. Do not pass Entity as a `@RequestBody`. Use DTO projection instead.
1. When you need to take LocalDate variable as input you may use this approach: `@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date`.
1. Feel free to pass `movieId` and `cinemaHallId` in MovieSessionRequestDto.
1. Implement mappers for each entity. Mark your mappers as `@Component`.

**You can check yourself using this [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-spring/rest/jv-spring-rest_checklist)**
