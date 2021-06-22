package mate.academy.spring.security.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Controller;

@Controller
public class MovieSessionDtoMapper {
    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto response = new MovieSessionResponseDto();
        response.setId(movieSession.getId());
        response.setMovie(movieSession.getMovie());
        response.setCinemaHall(movieSession.getCinemaHall());
        response.setShowTime(String.valueOf(movieSession.getShowTime()));
        return response;
    }

    public MovieSession toMovieSession(MovieSessionRequestDto movieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieSessionDto.getMovie());
        movieSession.setShowTime(movieSession.getShowTime());
        movieSession.setCinemaHall(movieSession.getCinemaHall());
        return movieSession;
    }
}
