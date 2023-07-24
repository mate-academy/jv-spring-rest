package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.request.MovieSessionRequestDto;
import mate.academy.spring.dto.response.MovieSessionResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setMovie(movieSession.getMovie().getId());
        dto.setCinemaHall(movieSession.getCinemaHall().getId());
        dto.setShowTime(movieSession.getShowTime());
        return dto;
    }

    public MovieSession toModel(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setCinemaHall(new CinemaHall(dto.getCinemaHallId()));
        movieSession.setMovie(new Movie((dto.getMovieId())));
        movieSession.setShowTime(dto.getShowTime());
        return movieSession;
    }
}
