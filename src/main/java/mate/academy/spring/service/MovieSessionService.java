package mate.academy.spring.service;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.model.MovieSession;

public interface MovieSessionService {
    MovieSession add(MovieSession session);

    MovieSession update(MovieSession session);

    public void delete(MovieSession session);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession get(Long id);
}
