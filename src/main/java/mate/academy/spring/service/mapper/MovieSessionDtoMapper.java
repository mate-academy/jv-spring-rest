package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.requests.MovieSessionDtoRequest;
import mate.academy.spring.dto.responses.MovieSessionDtoResponse;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    public MovieSessionDtoResponse toDto(MovieSession movieSession) {
        MovieSessionDtoResponse movieSessionDtoRequest = new MovieSessionDtoResponse();
        movieSessionDtoRequest.setId(movieSession.getId());
        movieSessionDtoRequest.setShowTime(movieSession.getShowTime());
        movieSessionDtoRequest.setMovieId(movieSession.getMovie().getId());
        movieSessionDtoRequest.setCinemaHallId(movieSession.getCinemaHall().getId());
        return movieSessionDtoRequest;
    }

    public MovieSession toModel(MovieSessionDtoRequest movieSessionDtoResponse) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionDtoResponse.getMovieId()));
        movieSession.setShowTime(movieSessionDtoResponse.getShowTime());
        movieSession.setCinemaHall(cinemaHallService
                .get(movieSessionDtoResponse.getCinemaHallId()));
        return movieSession;
    }
}
