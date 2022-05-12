package mate.academy.spring.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
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
    @Transactional
    public void update(Long id, MovieSession movieSession) throws Exception {
        Optional<MovieSession> movieSessionOptional = sessionDao.get(id);
        if (movieSessionOptional.isEmpty()) {
            throw new Exception("Movie Session not found id: " + id);
        }

        MovieSession movieSessionFromDB = movieSessionOptional.get();
        movieSessionFromDB.setShowTime(movieSession.getShowTime());
        movieSessionFromDB.setMovie(movieSession.getMovie());
        movieSessionFromDB.setCinemaHall(movieSession.getCinemaHall());
    }

    @Override
    public void delete(Long id) {
        MovieSession movieSession = sessionDao.get(id).get();
        movieSessionOptional.ifPresent(sessionDao::delete);
    }
}
