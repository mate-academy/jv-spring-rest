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
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaHallService hallService;

    public MovieSessionResponseDto parseToResp(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setMovie(movieSession.getMovie().getId());
        dto.setCinemaHall(movieSession.getCinemaHall().getId());
        dto.setShowTime(movieSession.getShowTime());
        return dto;
    }

    public MovieSession parseToModel(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setCinemaHall(hallService.get(dto.getCinemaHallId()));
        movieSession.setMovie(movieService.get(dto.getMovieId()));
        movieSession.setShowTime(dto.getShowTime());
        return movieSession;
    }
}
