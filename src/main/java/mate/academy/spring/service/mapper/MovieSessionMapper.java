package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService hallService;

    public MovieSessionMapper(MovieService movieService, CinemaHallService hallService) {
        this.movieService = movieService;
        this.hallService = hallService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto sessionResponseDto = new MovieSessionResponseDto();
        sessionResponseDto.setId(movieSession.getId());
        sessionResponseDto.setMovieId(movieSession.getMovie().getId());
        sessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        sessionResponseDto.setShowTime(movieSession.getShowTime());
        return sessionResponseDto;
    }

    public MovieSession toModel(@RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(hallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }
}
