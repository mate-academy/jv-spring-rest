package mate.academy.spring.service.mappers;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto =
                new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        Movie movie = new Movie();
        movie.setId(requestDto.getMovieId());
        movieSession.setMovie(movie);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(requestDto.getCinemaHallId());
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }
}
