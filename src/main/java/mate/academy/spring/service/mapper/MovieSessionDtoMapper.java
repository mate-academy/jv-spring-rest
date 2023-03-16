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
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaHallService cinemaHallService;

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    public MovieSession toModel(MovieSessionResponseDto movieSessionResponseDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setId(movieSessionResponseDto.getId());
        movieSession.setMovie(movieService.get(movieSessionResponseDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService
                .get(movieSessionResponseDto.getCinemaHallId()));
        movieSession.setShowTime(movieSessionResponseDto.getShowTime());
        return movieSession;
    }

    public MovieSession toModelRequest(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
