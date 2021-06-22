package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    
    public MovieSessionDtoMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }
    
    public MovieSessionResponseDto parseToDto(MovieSession movieSession) {
        return new MovieSessionResponseDto(
                movieSession.getId(),
                movieSession.getMovie().getId(),
                movieSession.getCinemaHall().getId(),
                movieSession.getShowTime());
    }
    
    public MovieSession parseToModel(MovieSessionRequestDto movieSessionRequestDto) {
        return new MovieSession(
                movieService.get(movieSessionRequestDto.getMovieId()),
                        cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()),
                        movieSessionRequestDto.getShowTime());
    }
}
