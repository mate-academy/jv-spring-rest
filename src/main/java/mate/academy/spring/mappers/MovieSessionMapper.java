package mate.academy.spring.mappers;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final CinemaHallMapper cinemaHallMapper;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieSessionMapper(CinemaHallMapper cinemaHallMapper,
                              MovieMapper movieMapper) {
        this.cinemaHallMapper = cinemaHallMapper;
        this.movieMapper = movieMapper;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setMovieId(movieSession.getMovie().getId());
        dto.setCinemaHallId(movieSession.getCinemaHall().getId());
        dto.setShowTime(movieSession.getShowTime());
        return dto;
    }

    public MovieSession formDto(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setId(dto.getId());
        movieSession.setMovie(movieMapper.fromDto(dto.getMovie()));
        movieSession.setCinemaHall(cinemaHallMapper.fromDto(dto.getCinemaHall()));
        movieSession.setShowTime(dto.getShowTime());
        return movieSession;
    }

}
