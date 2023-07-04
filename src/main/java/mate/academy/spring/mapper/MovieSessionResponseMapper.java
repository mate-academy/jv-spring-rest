package mate.academy.spring.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionResponseMapper {
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setMovieTitle(movieSession.getMovie().getTitle());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }
}
