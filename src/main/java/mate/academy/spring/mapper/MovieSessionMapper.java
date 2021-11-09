package mate.academy.spring.mapper;

import mate.academy.spring.dto.reques.MovieSessionRequestDto;
import mate.academy.spring.dto.response.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionMapper(MovieService movieService,
                              CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto parseToDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionDto =
                new MovieSessionResponseDto();
        movieSessionDto.setId(movieSession.getId());
        movieSessionDto
                .setMovieId(movieSession.getMovie().getId());
        movieSessionDto
                .setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionDto.setShowTime(movieSessionDto.getShowTime());
        return movieSessionDto;
    }

    public MovieSession parseToModel(MovieSessionRequestDto movieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService
                .get(movieSessionDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService
                .get(movieSessionDto.getCinemaHallId()));
        movieSession.setShowTime(movieSession.getShowTime());
        return movieSession;
    }
}
