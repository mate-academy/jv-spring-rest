package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto,
                                Movie movie,
                                CinemaHall cinemaHall) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto,
                                Movie movie,
                                CinemaHall cinemaHall,
                                Long id) {
        MovieSession movieSession = toModel(movieSessionRequestDto, movie, cinemaHall);
        movieSession.setId(id);
        return movieSession;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setId(movieSession.getId());
        return movieSessionResponseDto;
    }
}
