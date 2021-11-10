package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionDtoMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto sessionResponseDto = new MovieSessionResponseDto();
        sessionResponseDto.setId(movieSession.getId());
        sessionResponseDto.setMovieId(movieSession.getMovie().getId());
        sessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        sessionResponseDto.setShowTime(movieSession.getShowTime().toString());
        return sessionResponseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto sessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(sessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(sessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(sessionRequestDto.getShowTime());
        return movieSession;
    }

}
