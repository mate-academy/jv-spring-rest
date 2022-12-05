package mate.academy.spring.dto.mapper.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.spring.dto.MovieSessionDto;
import mate.academy.spring.dto.mapper.DtoMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper
        implements DtoMapper<MovieSession, MovieSessionDto> {
    private static final DateTimeFormatter DATE_TIME_FORMAT
            = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSessionDto toDto(MovieSession movieSession) {
        MovieSessionDto dto = new MovieSessionDto();
        dto.setId(movieSession.getId());
        dto.setMovieId(movieSession.getMovie().getId());
        dto.setCinemaHallId(movieSession.getCinemaHall().getId());
        dto.setShowTime(movieSession.getShowTime().format(DATE_TIME_FORMAT));
        return dto;
    }

    @Override
    public MovieSession toModel(MovieSessionDto dto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(dto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(dto.getCinemaHallId()));
        LocalDateTime showTime = LocalDateTime.parse(dto.getShowTime(), DATE_TIME_FORMAT);
        movieSession.setShowTime(showTime);
        return movieSession;
    }
}
