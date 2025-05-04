package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.request.MovieSessionRequestDto;
import mate.academy.spring.model.dto.response.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService,
                              CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toResponseDto(MovieSession movieSession) {
        return new MovieSessionResponseDto(
                movieSession.getId(),
                movieSession.getMovie().getTitle(),
                movieSession.getCinemaHall().getId(),
                movieSession.getShowTime()
        );
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }
}
