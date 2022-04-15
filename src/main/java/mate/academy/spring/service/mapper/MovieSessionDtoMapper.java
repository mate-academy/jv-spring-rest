package mate.academy.spring.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    public MovieSessionDtoMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setMovieId(movieSession.getMovie().getId());
        dto.setCinemaHallId(movieSession.getCinemaHall().getId());
        dto.setDate(movieSession.getShowTime());
        return dto;
    }

    public MovieSession toMovieSession(MovieSessionRequestDto dto) {
        MovieSession session = new MovieSession();
        session.setMovie(movieService.get(dto.getMovieId()));
        session.setCinemaHall(cinemaHallService.get(dto.getCinemaHallId()));
        session.setShowTime(LocalDateTime.parse(dto.getDate(),
                DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm")));
        return session;
    }
}
