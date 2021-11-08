package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapperDto {
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    public MovieSessionMapperDto(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toDto(MovieSession session) {
        return new MovieSessionResponseDto(session.getId(), session.getMovie(),
                session.getCinemaHall(), session.getShowTime());
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession session = new MovieSession();
        session.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        session.setCinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        session.setShowTime(movieSessionRequestDto.getShowTime());
        return session;
    }
}
