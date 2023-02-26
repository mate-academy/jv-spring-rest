package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieSessionService sessionService;

    public MovieSessionMapper(MovieSessionService sessionService) {
        this.sessionService = sessionService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setMovieId(movieSession.getMovie().getId());
        responseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        responseDto.setShowTime(movieSession.getShowTime());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(sessionService.get(requestDto.getMovieId()).getMovie());
        movieSession.setCinemaHall(sessionService
                .get(requestDto.getCinemaHallId()).getCinemaHall());
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }
}
