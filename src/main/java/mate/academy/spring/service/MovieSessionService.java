package mate.academy.spring.service;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Service;

@Service
public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession get(Long id);

    MovieSession add(MovieSession session);

    MovieSession update(MovieSession movieSession);

    void remove(Long id);
}
