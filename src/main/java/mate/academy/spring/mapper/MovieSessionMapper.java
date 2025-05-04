package mate.academy.spring.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionRespondDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    public MovieSessionMapper(CinemaHallService cinemaHallService, MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }

    public MovieSessionRespondDto toDto(MovieSession session) {
        MovieSessionRespondDto movieSessionRespondDto = new MovieSessionRespondDto();
        movieSessionRespondDto.setId(session.getId());
        movieSessionRespondDto.setMovieId(session.getMovie().getId());
        movieSessionRespondDto.setCinemaHallId(session.getCinemaHall().getId());
        movieSessionRespondDto.setShowTime(session.getShowTime());
        return movieSessionRespondDto;
    }
}
