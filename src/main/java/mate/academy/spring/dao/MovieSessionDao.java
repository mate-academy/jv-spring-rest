package mate.academy.spring.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.MovieSession;

public interface MovieSessionDao extends GenericDao<MovieSession> {
    Optional<MovieSession> get(Long id);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate localDate);

    void remove(Long id);

    MovieSession update(MovieSession movieSession);

}
