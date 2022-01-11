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
        return MovieSessionResponseDto.builder()
                .id(movieSession.getId())
                .showTime(movieSession.getShowTime())
                .movieId(movieSession.getMovie().getId())
                .cinemaHallId(movieSession.getCinemaHall().getId())
                .build();
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        return MovieSession.builder()
                .showTime(requestDto.getShowTime())
                .movie(movieService.get(requestDto.getMovieId()))
                .cinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()))
                .build();
    }
}
