package mate.academy.spring.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.MovieSession;

public interface MovieSessionDao extends GenericDao<MovieSession> {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession movieSession);

    Optional<MovieSession> get(Long id);

    List<MovieSession> getAll();

    void delete(MovieSession movieSession);

    MovieSession update(MovieSession movieSession);
}
