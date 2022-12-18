package mate.academy.spring.service.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieSessionService movieSessionService;
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieSessionService movieSessionService,
                              MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieSessionService = movieSessionService;
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto
                = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    public List<MovieSessionResponseDto> findAvailableMovieSessions(
            Long movieId, LocalDate localDate) {
        return movieSessionService.findAvailableSessions(movieId, localDate).stream()
                .map(this::parse)
                .collect(Collectors.toList());
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }

    public MovieSessionResponseDto update(Long id, MovieSessionRequestDto requestDto) {
        MovieSession movieSession = toModel(requestDto);
        movieSession.setId(id);
        return parse(movieSessionService.update(movieSession));
    }
}
