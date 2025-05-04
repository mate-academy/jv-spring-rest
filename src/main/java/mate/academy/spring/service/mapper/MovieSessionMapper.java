package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionDtoRequest;
import mate.academy.spring.model.dto.MovieSessionDtoResponse;
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

    public MovieSessionDtoResponse toDto(MovieSession movieSession) {
        MovieSessionDtoResponse movieSessionResponseDto = new MovieSessionDtoResponse();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    public MovieSession toModel(MovieSessionDtoRequest movieSessionDtoRequest) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionDtoRequest.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionDtoRequest.getCinemaHallId()));
        movieSession.setShowTime(movieSessionDtoRequest.getShowTime());
        return movieSession;
    }
}
