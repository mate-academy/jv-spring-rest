package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapperImpl implements MovieSessionMapper {
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovie(movieSession.getMovie());
        movieSessionResponseDto.setCinemaHall(movieSession.getCinemaHall());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    @Override
    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieSessionRequestDto.getMovie());
        movieSession.setCinemaHall(movieSessionRequestDto.getCinemaHall());
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return null;
    }
}
