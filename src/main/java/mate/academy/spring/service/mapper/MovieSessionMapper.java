package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.moviesession.MovieSessionRequestDto;
import mate.academy.spring.model.dto.moviesession.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(new Movie(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(new CinemaHall(movieSessionRequestDto.getMovieId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }
}
