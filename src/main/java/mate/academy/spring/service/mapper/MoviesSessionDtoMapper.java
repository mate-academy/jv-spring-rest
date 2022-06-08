package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MoviesSessionDtoMapper {
    private final MovieService sessionService;
    private final CinemaHallService hallService;

    public MoviesSessionDtoMapper(MovieService sessionService, CinemaHallService hallService) {
        this.sessionService = sessionService;
        this.hallService = hallService;
    }

    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setMovieId(movieSession.getMovie().getId());
        responseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        responseDto.setShowTime(movieSession.getShowTime());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(sessionService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(hallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }
}
