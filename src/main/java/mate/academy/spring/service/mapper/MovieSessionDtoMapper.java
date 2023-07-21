package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.request.MovieSessionRequestDto;
import mate.academy.spring.model.dto.response.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setMovie(movieSession.getMovie());
        responseDto.setCinemaHall(movieSession.getCinemaHall());
        responseDto.setShowTime(movieSession.getShowTime());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieSessionDto.getMovie());
        movieSession.setCinemaHall(movieSessionDto.getCinemaHall());
        movieSession.setShowTime(movieSessionDto.getShowTime());
        return movieSession;
    }
}
