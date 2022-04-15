package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponceDto;
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

    public MovieSessionResponceDto parseToDto(MovieSession movieSession) {
        MovieSessionResponceDto movieSessionResponceDto = new MovieSessionResponceDto();
        movieSessionResponceDto.setId(movieSession.getId());
        movieSessionResponceDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponceDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponceDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponceDto;
    }

    public MovieSession parseToModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
