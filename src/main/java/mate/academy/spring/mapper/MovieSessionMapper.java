package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;

public class MovieSessionMapper {

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setMovie(movieSession.getMovie());
        responseDto.setCinemaHall(movieSession.getCinemaHall());
        responseDto.setShowTime(movieSession.getShowTime());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(requestDto.getMovie());
        movieSession.setCinemaHall(requestDto.getCinemaHall());
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }
}
