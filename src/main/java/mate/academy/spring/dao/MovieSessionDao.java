package mate.academy.spring.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.MovieSession;

public interface MovieSessionDao extends GenericDao<MovieSession> {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    List<MovieSession> findAllByMovieId(Long movieId);

    Optional<MovieSession> get(Long id);

    MovieSession update(MovieSession session);

    void delete(Long id);

    List<MovieSession> getAll();
}
