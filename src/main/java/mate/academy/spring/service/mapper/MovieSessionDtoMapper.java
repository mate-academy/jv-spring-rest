package mate.academy.spring.service.mapper;

import java.time.LocalDateTime;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionDtoMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setShowTime(movieSession.getShowTime());
        responseDto.setMovieId(movieSession.getMovie().getId());
        responseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setShowTime(LocalDateTime.parse(requestDto.getShowTime()));
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        return movieSession;
    }
}
