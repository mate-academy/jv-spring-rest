package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MoviesMapper moviesMapper;
    private final CinemaHallMapper cinemaHallMapper;

    public MovieSessionMapper(MovieService movieService,
                              CinemaHallService cinemaHallService,
                              MoviesMapper moviesMapper, CinemaHallMapper cinemaHallMapper) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.moviesMapper = moviesMapper;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(movieSessionRequestDto.getLocalDateTime());
        return movieSession;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieResponseDto(moviesMapper
                .toDto(movieSession.getMovie()));
        movieSessionResponseDto.setCinemaHallResponseDto(cinemaHallMapper
                .toDto(movieSession.getCinemaHall()));
        movieSessionResponseDto.setLocalDateTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }
}
