package mate.academy.spring.service.mapper;

import lombok.AllArgsConstructor;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieSessionDtoMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

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
        movieSession.setShowTime(requestDto.getShowTime());
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        return movieSession;
    }
}
