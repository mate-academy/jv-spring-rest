package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.request.MovieSessionRequestDto;
import mate.academy.spring.dto.response.MovieSessionResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setMovieId(movieSession.getMovie().getId());
        responseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        responseDto.setShowTime(movieSession.getShowTime());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setShowTime(requestDto.getShowTime());
        movieSession.setMovie(new Movie(requestDto.getMovieId()));
        movieSession.setCinemaHall(new CinemaHall(requestDto.getCinemaHallId()));
        return movieSession;
    }
}
