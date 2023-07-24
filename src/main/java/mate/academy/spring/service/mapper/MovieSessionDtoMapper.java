package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    public MovieSessionResponseDto entityToDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHall(movieSession.getCinemaHall().getId());
        movieSession.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    public MovieSession dtoToEntity(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        Movie movie = new Movie();
        movie.setId(movieSessionRequestDto.getMovieId());
        movieSession.setMovie(movie);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(movieSessionRequestDto.getCinemaHallId());
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
