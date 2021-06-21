package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    public MovieSessionDto parseToDto(MovieSession movieSession) {
        MovieSessionDto movieSessionDto = new MovieSessionDto();
        movieSessionDto.setMovie(movieSession.getMovie());
        movieSessionDto.setId(movieSession.getId());
        movieSessionDto.setCinemaHall(movieSession.getCinemaHall());
        movieSessionDto.setShowTime(movieSession.getShowTime());
        return movieSessionDto;
    }

    public MovieSession parseToModel(MovieSessionDto movieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieSessionDto.getMovie());
        movieSession.setId(movieSessionDto.getId());
        movieSession.setCinemaHall(movieSessionDto.getCinemaHall());
        movieSession.setShowTime(movieSessionDto.getShowTime());
        return movieSession;
    }
}
