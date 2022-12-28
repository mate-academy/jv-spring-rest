package mate.academy.spring.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.spring.dto.request.MovieSessionRequestDto;
import mate.academy.spring.dto.response.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private static final String DATE_TIME_FORMAT_IN_REQUEST = "dd-MM-yyyy-HH-mm";
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionDto = new MovieSessionResponseDto();
        movieSessionDto.setId(movieSession.getId());
        movieSessionDto.setMovieId(movieSession.getMovie().getId());
        movieSessionDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionDto.setShowTime(movieSession.getShowTime().toString());
        return movieSessionDto;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionDto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(movieSessionDto.getShowTime(),
                        DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_IN_REQUEST)));
        return movieSession;
    }
}
