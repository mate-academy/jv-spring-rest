package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setMovie(movieSession.getMovie());
        responseDto.setShowTime(movieSession.getShowTime());
        responseDto.setCinemaHall(movieSession.getCinemaHall());
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
