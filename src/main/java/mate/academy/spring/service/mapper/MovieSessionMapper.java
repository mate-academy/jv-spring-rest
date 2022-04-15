package mate.academy.spring.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService,
                              CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto response = new MovieSessionResponseDto();
        response.setId(movieSession.getId());
        response.setMovieId(movieSession.getMovie().getId());
        response.setCinemaHallId(movieSession.getCinemaHall().getId());
        response.setShowTimeString(movieSession.getShowTime().toString());
        return response;
    }

    public MovieSession toModel(MovieSessionRequestDto request) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(request.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(request.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(request.getShowTimeString(),
                DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
        return movieSession;
    }
}
