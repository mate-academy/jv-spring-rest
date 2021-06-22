package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.request.MovieSessionRequestDto;
import mate.academy.spring.model.dto.response.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    public MovieSessionResponseDto mapToDto(MovieSession movieSession) {
        MovieSessionResponseDto response = new MovieSessionResponseDto();
        response.setId(movieSession.getId());
        response.setMovieId(movieSession.getMovie().getId());
        response.setCinemaHallId(movieSession.getCinemaHall().getId());
        response.setShowTime(String.valueOf(movieSession.getShowTime()));
        return response;
    }

    public MovieSession mapToModel(MovieSessionRequestDto movieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieSessionDto.getMovie());
        movieSession.setShowTime(movieSession.getShowTime());
        movieSession.setCinemaHall(movieSession.getCinemaHall());
        return movieSession;
    }
}
