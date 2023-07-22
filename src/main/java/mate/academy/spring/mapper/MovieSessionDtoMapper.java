package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(responseDto.getId());
        responseDto.setMovieId(responseDto.getMovieId());
        responseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        responseDto.setShowTime(responseDto.getShowTime());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(new Movie(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(new CinemaHall(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(movieSession.getShowTime());
        return movieSession;
    }
}
