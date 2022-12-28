package mate.academy.spring.service.impl;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.dao.MovieSessionDao;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao sessionDao;

    public MovieSessionServiceImpl(MovieSessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return sessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession get(Long id) {
        return sessionDao.get(id).get();
    }

    @Override
    public MovieSession add(MovieSession session) {
        return sessionDao.add(session);
    }

    @Override
    public MovieSession update(MovieSession session) {
        return sessionDao.update(session);
    }

    @Override
    public void delete(Long id) {
        MovieSession movieSession = get(id);
        movieSession.setDeleted(true);
        sessionDao.update(movieSession);
    }
}
