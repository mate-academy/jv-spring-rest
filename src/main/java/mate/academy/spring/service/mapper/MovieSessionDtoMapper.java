package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private CinemaHallService cinemaHallService;
    private MovieService movieService;

    @Autowired
    public MovieSessionDtoMapper(CinemaHallService cinemaHallService, MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto msrd = new MovieSessionResponseDto();
        msrd.setId(movieSession.getId());
        msrd.setCinemaHall(movieSession.getCinemaHall().getId());
        msrd.setMovie(movieSession.getMovie().getId());
        msrd.setShowTime(movieSession.getShowTime());
        return msrd;
    }

    public MovieSession toModel(MovieSessionRequestDto msrd) {
        MovieSession movieSession = new MovieSession();
        movieSession.setCinemaHall(cinemaHallService.get(msrd.getCinemaHall()));
        movieSession.setMovie(movieService.get(msrd.getMovie()));
        return movieSession;
    }
}
