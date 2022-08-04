package mate.academy.spring.model.mapper;

import mate.academy.spring.dto.RequestMovieSessionDto;
import mate.academy.spring.dto.ResponseMovieSessionDto;
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

    public ResponseMovieSessionDto toDto(MovieSession movieSession) {
        ResponseMovieSessionDto responseMovieSessionDto = new ResponseMovieSessionDto();
        responseMovieSessionDto.setMovieId(movieSession.getMovie().getId());
        responseMovieSessionDto.setId(movieSession.getId());
        responseMovieSessionDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        responseMovieSessionDto.setShowTime(movieSession.getShowTime());
        return responseMovieSessionDto;
    }

    public MovieSession toModel(RequestMovieSessionDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }
}
