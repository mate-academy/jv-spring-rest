package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.dto.MovieSessionResponseDtoFull;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionDtoMapper (MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toDto (MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    public MovieSessionResponseDtoFull toDtoFull(MovieSession movieSession) {
        MovieSessionResponseDtoFull movieSessionResponseDtoFull = new MovieSessionResponseDtoFull();
        movieSessionResponseDtoFull.setId(movieSession.getId());
        Movie movie = movieSession.getMovie();
        movieSessionResponseDtoFull.setMovieId(movie.getId());
        movieSessionResponseDtoFull.setMovieTitle(movie.getTitle());
        movieSessionResponseDtoFull.setMovieDescription(movie.getDescription());
        CinemaHall cinemaHall = movieSession.getCinemaHall();
        movieSessionResponseDtoFull.setCinemaHallId(cinemaHall.getId());
        movieSessionResponseDtoFull.setCinemaHallCapacity(cinemaHall.getCapacity());
        movieSessionResponseDtoFull.setCinemaHallDescription(cinemaHall.getDescription());
        movieSessionResponseDtoFull.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDtoFull;
    }

    public MovieSession toModel (MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
