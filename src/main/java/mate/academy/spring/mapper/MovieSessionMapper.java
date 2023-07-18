package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        return new MovieSessionResponseDto(movieSession.getId(),
                movieSession.getMovie().getId(),
                movieSession.getCinemaHall().getId(),
                movieSession.getShowTime());
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        return new MovieSession(movieService.get(movieSessionRequestDto.getMovieId()),
                cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()),
                movieSessionRequestDto.getShowTime());
    }
}
