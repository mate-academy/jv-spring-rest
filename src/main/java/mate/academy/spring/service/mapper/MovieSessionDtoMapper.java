package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.request.MovieSessionRequestDto;
import mate.academy.spring.dto.response.MovieSessionResponseDto;
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
        MovieSessionResponseDto sessionDto = new MovieSessionResponseDto();
        sessionDto.setId(movieSession.getId());
        sessionDto.setMovie(movieSession.getMovie());
        sessionDto.setCinemaHall(movieSession.getCinemaHall());
        sessionDto.setShowTime(movieSession.getShowTime());
        return sessionDto;
    }

    public MovieSession parseToModel(MovieSessionRequestDto movieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionDto.getCinemaHallId()));
        movieSession.setShowTime(movieSessionDto.getShowTime());
        return movieSession;
    }
}
