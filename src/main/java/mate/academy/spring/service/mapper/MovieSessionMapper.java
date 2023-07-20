package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;

public class MovieSessionMapper {

    public MovieSessionResponseDto parseToResp(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setMovie(movieSession.getMovie());
        dto.setCinemaHall(movieSession.getCinemaHall());
        dto.setShowTime(movieSession.getShowTime());
        return dto;
    }
}
