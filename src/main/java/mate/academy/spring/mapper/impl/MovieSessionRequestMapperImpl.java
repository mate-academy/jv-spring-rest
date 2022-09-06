package mate.academy.spring.mapper.impl;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.mapper.MovieSessionRequestMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionRequestMapperImpl implements MovieSessionRequestMapper {
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionRequestMapperImpl(MovieService movieService,
                                         CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSession toModel(MovieSessionRequestDto request) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(request.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(request.getCinemaHallId()));
        movieSession.setShowTime(request.getShowTime());
        return movieSession;
    }
}
