package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieMapper movieMapper;
    private final CinemaHallMapper cinemaHallMapper;

    @Autowired
    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService,
                              MovieMapper movieMapper, CinemaHallMapper cinemaHallMapper) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieMapper = movieMapper;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieDto(movieMapper.parse(movieSession.getMovie()));
        movieSessionResponseDto.setCinemaHallDto(cinemaHallMapper
                .parse(movieSession.getCinemaHall()));
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieDto().getId()));
        movieSession.setCinemaHall(cinemaHallService
                .get(movieSessionRequestDto.getCinemaHallDto().getId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
