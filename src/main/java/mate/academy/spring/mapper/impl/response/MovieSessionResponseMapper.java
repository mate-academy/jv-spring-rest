package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.dto.response.MovieSessionResponseDto;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionResponseMapper
        implements DtoResponseMapper<MovieSession, MovieSessionResponseDto> {
    @Override
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setMovieId(movieSession.getMovie().getId());
        dto.setCinemaHallId(movieSession.getCinemaHall().getId());
        dto.setShowTime(movieSession.getShowTime());
        return dto;
    }
}
