package mate.academy.spring.service.mapper;

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

    public MovieSessionResponseDto toDto(MovieSession session) {
        MovieSessionResponseDto sessionResponseDto = new MovieSessionResponseDto();
        sessionResponseDto.setId(session.getId());
        sessionResponseDto.setMovieId(session.getMovie().getId());
        sessionResponseDto.setCinemaHallId(session.getCinemaHall().getId());
        sessionResponseDto.setShowTime(session.getShowTime());
        return sessionResponseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto sessionRequestDto) {
        MovieSession session = new MovieSession();
        session.setMovie(movieService.get(sessionRequestDto.getMovieId()));
        session.setCinemaHall(cinemaHallService.get(sessionRequestDto.getCinemaHallId()));
        session.setShowTime(sessionRequestDto.getShowTime());
        return session;
    }
}
