package mate.academy.spring.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
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
        return sessionDao.get(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return sessionDao.add(session);
    }

    @Override
    public boolean delete(Long id) {
        return sessionDao.delete(id);
    }

    @Override
    public MovieSession update(MovieSession movieSession) {
        return sessionDao.update(movieSession);
    }
}
