package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieSessionService movieSessionService;

    public MovieSessionMapper(MovieSessionService movieSessionService) {
        this.movieSessionService = movieSessionService;
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
        movieSession.setMovie(movieSessionService.getMovie(requestDto.getMovieId()));
        movieSession
                .setCinemaHall(movieSessionService.getCinemaHall(requestDto.getCinemaHallId()));
        movieSession.setShowTime(requestDto.getShowTime());

        return movieSession;
    }
}
