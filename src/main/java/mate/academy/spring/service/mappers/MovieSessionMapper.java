package mate.academy.spring.service.mappers;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService,
                              CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto parseToDto(MovieSession movieSession) {
        MovieSessionResponseDto movieResponseDto = new MovieSessionResponseDto();
        movieResponseDto.setId(movieSession.getId());
        movieResponseDto.setMovieId(movieSession.getMovie().getId());
        movieResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieResponseDto.setShowTime(movieSession.getShowTime());
        return movieResponseDto;
    }

    public MovieSession parseToModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(movieSession.getShowTime());
        return movieSession;
    }
}
