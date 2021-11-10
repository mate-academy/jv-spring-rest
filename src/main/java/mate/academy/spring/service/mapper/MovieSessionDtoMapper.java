package mate.academy.spring.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionDtoMapper {
    private static final String DATE_PATTERN = "dd.MM.yyyy HH:mm";

    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    @Autowired
    public MovieSessionDtoMapper(CinemaHallService cinemaHallService, MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto =
                    new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        return movieSessionResponseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        Movie movie = movieService.get(movieSessionRequestDto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.get(movieSessionRequestDto.getCinemaHallId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        movieSession.setMovie(movie);
        movieSession.setShowTime(LocalDateTime
                    .parse(movieSessionRequestDto.getShowTime(), formatter));
        movieSession.setCinemaHall(cinemaHall);
        return movieSession;
    }
}
