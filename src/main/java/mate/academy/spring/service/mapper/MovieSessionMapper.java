package mate.academy.spring.service.mapper;

import java.time.LocalDateTime;
import java.time.LocalTime;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    @Autowired
    private CinemaHallService cinemaHallService;
    @Autowired
    private MovieService movieService;

    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setMovieId(movieSession.getMovie().getId());
        dto.setCinemaHall(movieSession.getCinemaHall().getId());
        dto.setShowTime(movieSession.getShowTime().toLocalDate());
        return dto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.of(requestDto.getShowTime(), LocalTime.now()));
        return movieSession;
    }
}
