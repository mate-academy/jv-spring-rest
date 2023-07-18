package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.moviesession.MovieSessionRequestDto;
import mate.academy.spring.dto.moviesession.MovieSessionResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        return new MovieSession(new Movie(movieSessionRequestDto.getMovieId()),
                new CinemaHall(movieSessionRequestDto.getCinemaHallId()),
                movieSessionRequestDto.getShowTime());
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        return new MovieSessionResponseDto(movieSession.getId(),
                movieSession.getMovie().getId(),
                movieSession.getCinemaHall().getId(),
                movieSession.getShowTime());
    }
}
