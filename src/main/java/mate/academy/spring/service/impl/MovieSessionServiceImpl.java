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
    public void delete(Long id) {
        sessionDao.delete(sessionDao.get(id).get());
    }

    @Override
    public MovieSession update(Long id, MovieSession receivedMovieSession) {
        MovieSession updatedMovieSession = sessionDao.get(id).get();
        if (receivedMovieSession.getMovie() != null) {
            updatedMovieSession.setMovie(receivedMovieSession.getMovie());
        }
        if (receivedMovieSession.getCinemaHall() != null) {
            updatedMovieSession.setCinemaHall(receivedMovieSession.getCinemaHall());
        }
        if (receivedMovieSession.getShowTime() != null) {
            updatedMovieSession.setShowTime(receivedMovieSession.getShowTime());
        }

        sessionDao.update(updatedMovieSession);
        return updatedMovieSession;
    }
}
