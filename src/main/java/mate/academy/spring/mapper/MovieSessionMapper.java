package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    public MovieSessionResponseDto toDo(MovieSession movieSession) {
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
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        movieSession.setMovie(new Movie(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(new CinemaHall(movieSessionRequestDto.getCinemaHallId()));
        return movieSession;
    }
}
