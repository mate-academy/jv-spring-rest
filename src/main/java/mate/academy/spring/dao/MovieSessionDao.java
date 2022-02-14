package mate.academy.spring.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.MovieSession;

public interface MovieSessionDao extends GenericDao<MovieSession> {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    Optional<MovieSession> get(Long id);

    MovieSession add(MovieSession session);

    MovieSession update(MovieSession session);

    void delete(Long id);

}
