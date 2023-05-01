## Common mistakes (jv-spring-rest)

* Make your code consistent. Use the @Autowired annotation everywhere with the constructors or delete it from everywhere.
* Return `id` of entity in all response DTOs.
* Remember about [REST resource-naming convention](https://restfulapi.net/resource-naming/).
* In your mappers prefer setters over big constructors while converting entity to dto and vice versa.
* Use Stream API while working with lists in your mappers.
* In your MovieSessionRequest/ResponseDtos, you don't need to pass the whole information about Movie and CinemaHall - 
their ids will be enough.
* Creating a MovieSession from RequestDto in the mapper you do not need to fetch Movie and CinemaHall from the DB by Ids. 
Their Ids would be enough for Hibernate to save a new object with relations to DB: `movieSession.setMovie(new Movie(dto.getMovieId()));`  
* When creating a MovieSession, if you need to accept `LocalDateTime` in request body - 
add `jackson-datatype-jsr310` dependency to be able to parse it into MovieSessionRequestDto.
* Your method names in controllers and mappers should have uniform names.

Bad example:
```
public MovieResponseDto createMovie(@RequestBody MovieRequestDto movieRequestDto) { ... } 

public List<MovieResponseDto> getAll() { ... }
```

Good example:
```
public MovieResponseDto create(@RequestBody MovieRequestDto movieRequestDto) { ... } 

public List<MovieResponseDto> getAll() { ... }
```

Another bad example for mapper:
```
public CinemaHallResponseDto parse(CinemaHall cinemaHall) { ... }

public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) { ... }
```

Good example:
```
public CinemaHallResponseDto toDto(CinemaHall cinemaHall) { ... }

public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) { ... }
```
* When deleting a MovieSession on dao layer, double-check that you are not opening another Session
in your currently opened Session.
