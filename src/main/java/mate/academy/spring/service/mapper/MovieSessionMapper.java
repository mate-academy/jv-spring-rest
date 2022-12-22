package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSession mapToModel(MovieSessionRequestDto dto) {
        MovieSession model = new MovieSession();
        model.setMovie(movieService.get(dto.getMovieId()));
        model.setCinemaHall(cinemaHallService.get(dto.getCinemaHallId()));
        model.setShowTime(dto.getShowTime());
        return model;
    }

    public MovieSessionResponseDto mapToDto(MovieSession model) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(model.getId());
        dto.setMovieId(model.getMovie().getId());
        dto.setCinemaHallId(model.getCinemaHall().getId());
        dto.setShowTime(model.getShowTime());
        return dto;
    }
}
