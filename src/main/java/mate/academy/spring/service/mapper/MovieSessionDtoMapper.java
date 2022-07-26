package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setMovie(movieSession.getMovie());
        responseDto.setCinemaHall(movieSession.getCinemaHall());
        responseDto.setShowTime(movieSession.getShowTime());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieSessionRequestDto.getMovie());
        movieSession.setCinemaHall(movieSessionRequestDto.getCinemaHall());
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
