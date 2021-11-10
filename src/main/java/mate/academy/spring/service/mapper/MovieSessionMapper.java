package mate.academy.spring.service.mapper;

import java.time.format.DateTimeFormatter;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    private final MovieSessionService movieSessionService;

    public MovieSessionMapper(MovieSessionService movieSessionService) {
        this.movieSessionService = movieSessionService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime()
                .format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        return movieSessionResponseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieSessionService.get(requestDto.getMovieId()).getMovie());
        movieSession.setCinemaHall(movieSessionService.get(requestDto.getCinemaHallId())
                .getCinemaHall());
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }
}
