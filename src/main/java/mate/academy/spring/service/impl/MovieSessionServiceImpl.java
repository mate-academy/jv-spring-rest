package mate.academy.spring.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import mate.academy.spring.dao.MovieSessionDao;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao sessionDao;

    @Autowired
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
    public MovieSession update(MovieSession movieSession) {
        return sessionDao.update(movieSession).orElseThrow(() ->
                new NoSuchElementException("The movie session is absent in DB")
        );
    }

    @Override
    public void delete(Long id) {
        sessionDao.delete(sessionDao.get(id).orElseThrow());
    }
}
