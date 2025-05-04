package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto respDto = new MovieSessionResponseDto();
        respDto.setId(movieSession.getId());
        respDto.setMovieId(movieSession.getMovie().getId());
        respDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        respDto.setShowTime(movieSession.getShowTime());
        return respDto;
    }

    public MovieSession toModel(MovieSessionRequestDto reqDto) {
        MovieSession movieSession = new MovieSession();
        Movie movie = new Movie();
        movie.setId(reqDto.getMovieId());
        movieSession.setMovie(movie);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(reqDto.getCinemaHallId());
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(reqDto.getShowTime());
        return movieSession;
    }
}
