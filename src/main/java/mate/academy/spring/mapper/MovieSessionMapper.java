package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieMapper movieMapper;
    private final CinemaHallMapper cinemaHallMapper;
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieMapper movieMapper,
                              CinemaHallMapper cinemaHallMapper,
                              MovieService movieService,
                              CinemaHallService cinemaHallService) {
        this.movieMapper = movieMapper;
        this.cinemaHallMapper = cinemaHallMapper;
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieDto(movieMapper.parse(movieSession.getMovie()));
        movieSessionResponseDto.setCinemaHallDto(
                cinemaHallMapper.parse(movieSession.getCinemaHall()));
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    public MovieSession convert(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(
                movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(
                cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
