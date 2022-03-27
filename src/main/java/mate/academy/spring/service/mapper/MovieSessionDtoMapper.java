package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private CinemaHallService cinemaHallService;
    private MovieService movieService;

    @Autowired
    public MovieSessionDtoMapper(CinemaHallService cinemaHallService, MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime().toString());
        return movieSessionResponseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
