package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
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

    public MovieSessionResponseDto parseToDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionDto = new MovieSessionResponseDto();
        movieSessionDto.setMovieId(movieSession.getMovie().getId());
        movieSessionDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionDto.setShowTime(movieSession.getShowTime());
        movieSessionDto.setId(movieSession.getId());
        return movieSessionDto;
    }

    public MovieSession parseFromDto(MovieSessionRequestDto movieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setShowTime(movieSessionDto.getShowTime());
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionDto.getCinemaHallId()));
        movieSession.setMovie(movieService.get(movieSessionDto.getMovieId()));
        return movieSession;
    }
}
