package mate.academy.spring.service;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession get(Long id);

    Movie getMovie(Long id);

    CinemaHall getCinemaHall(Long id);

    MovieSession add(MovieSession session);

    MovieSession update(MovieSession session);

    boolean delete(Long id);
}
