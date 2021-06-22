package mate.academy.spring.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm");

    public MovieSessionResponseDto parseToDto(MovieSession movieSession) {

        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovie(movieSession.getMovie());
        movieSessionResponseDto.setCinemaHall(movieSession.getCinemaHall());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime().format(formatter));
        return movieSessionResponseDto;
    }

    public MovieSession parseToModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieSessionRequestDto.getMovie());
        movieSession.setCinemaHall(movieSessionRequestDto.getCinemaHall());
        movieSession.setShowTime(LocalDateTime.parse(movieSessionRequestDto.getShowTime(),
                formatter));
        return movieSession;
    }
}
