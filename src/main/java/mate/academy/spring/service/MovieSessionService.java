package mate.academy.spring.service;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession get(Long id);

    MovieSession add(MovieSession session);

    List<MovieSession> getAll();

    MovieSession update(MovieSession movieSession);

    void delete(MovieSession movieSession);
}
