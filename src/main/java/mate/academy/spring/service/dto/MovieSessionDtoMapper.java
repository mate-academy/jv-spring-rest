package mate.academy.spring.service.dto;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionDtoMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setMovieId(movieSession.getMovie().getId());
        dto.setCinemaHallId(movieSession.getCinemaHall().getId());
        dto.setShowTime(movieSession.getShowTime());
        return dto;
    }

    public MovieSession toModel(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        Long movieId = dto.getMovieId();
        Long cinemaHallId = dto.getCinemaHallId();
        movieSession.setMovie(movieService.get(movieId));
        movieSession.setCinemaHall(cinemaHallService.get(cinemaHallId));
        movieSession.setShowTime(dto.getShowTime());
        return movieSession;
    }
}
