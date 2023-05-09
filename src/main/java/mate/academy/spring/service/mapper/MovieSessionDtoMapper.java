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
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setCinemaHall(movieSession.getCinemaHall().getId());
        responseDto.setMovie(movieSession.getMovie().getId());
        responseDto.setShowTime(movieSession.getShowTime());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHall()));
        movieSession.setMovie(movieService.get(requestDto.getMovie()));
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }
}
