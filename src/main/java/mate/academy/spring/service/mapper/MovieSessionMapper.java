package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionMapper(MovieService movieService,
                              CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toResponseDto(MovieSession model) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(model.getId());
        responseDto.setMovieId(model.getMovie().getId());
        responseDto.setCinemaHallId(model.getCinemaHall().getId());
        responseDto.setShowTime(model.getShowTime());
        return responseDto;
    }

    public MovieSessionRequestDto toRequestDto(MovieSession model) {
        MovieSessionRequestDto requestDto = new MovieSessionRequestDto();
        requestDto.setMovieId(model.getMovie().getId());
        requestDto.setCinemaHallId(model.getCinemaHall().getId());
        requestDto.setShowTime(model.getShowTime());
        return requestDto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession model = new MovieSession();
        model.setMovie(movieService.get(requestDto.getMovieId()));
        model.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        model.setShowTime(requestDto.getShowTime());
        return model;
    }

}
