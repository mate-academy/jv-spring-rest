package mate.academy.spring.service.impl;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.dao.MovieSessionDao;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession get(Long id) {
        return movieSessionDao.get(id).get();
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }

    @Override
    public MovieSession update(MovieSession session) {
        return movieSessionDao.update(session);
    }

    @Override
    public void delete(MovieSession movieSession) {
        movieSessionDao.delete(movieSession);
    }
}
