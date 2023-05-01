package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
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

    public MovieSessionResponseDto toRespDto(MovieSession movieSession) {
        MovieSessionResponseDto respDto = new MovieSessionResponseDto();
        respDto.setId(movieSession.getId());
        respDto.setMovieId(movieSession.getMovie().getId());
        respDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        respDto.setShowTime(movieSession.getShowTime());
        return respDto;
    }

    public MovieSession fromReqDto(MovieSessionRequestDto reqDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(reqDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(reqDto.getCinemaHallId()));
        movieSession.setShowTime(reqDto.getShowTime());
        return movieSession;
    }
}
