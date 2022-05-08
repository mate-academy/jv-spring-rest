package mate.academy.spring.transformer;

import mate.academy.spring.dto.MovieSessionDto;
import mate.academy.spring.model.MovieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionTransformer {
    private final CinemaHallTransformer cinemaHallTransformer;
    private final MovieTransformer movieTransformer;

    @Autowired
    public MovieSessionTransformer(CinemaHallTransformer cinemaHallTransformer, MovieTransformer movieTransformer) {
        this.cinemaHallTransformer = cinemaHallTransformer;
        this.movieTransformer = movieTransformer;
    }

    public MovieSessionDto toDto(MovieSession movieSession) {
        MovieSessionDto dto = new MovieSessionDto();
        dto.setId(movieSession.getId());
        dto.setMovie(movieTransformer.toDto(movieSession.getMovie()));
        dto.setCinemaHall(cinemaHallTransformer.toDto(movieSession.getCinemaHall()));
        dto.setShowTime(movieSession.getShowTime());
        return dto;
    }

    public MovieSession formFromDto(MovieSessionDto dto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setId(dto.getId());
        movieSession.setMovie(movieTransformer.fromDto(dto.getMovie()));
        movieSession.setCinemaHall(cinemaHallTransformer.fromDto(dto.getCinemaHall()));
        movieSession.setShowTime(dto.getShowTime());
        return movieSession;
    }

}
