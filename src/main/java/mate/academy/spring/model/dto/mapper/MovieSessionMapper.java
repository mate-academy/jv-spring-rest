package mate.academy.spring.model.dto.mapper;

import java.time.LocalDateTime;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
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

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        Long id = movieSession.getId();
        Long movieId = movieSession.getMovie().getId();
        Long cinemaHallId = movieSession.getCinemaHall().getId();
        LocalDateTime showTime = movieSession.getShowTime();
        return new MovieSessionResponseDto(id, movieId, cinemaHallId, showTime);
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.movieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.cinemaHallId()));
        movieSession.setShowTime(requestDto.showTime());
        return movieSession;
    }
}
