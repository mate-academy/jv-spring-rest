package mate.academy.spring.dao.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.MovieSessionDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.MovieSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl extends AbstractDao<MovieSession> implements MovieSessionDao {
    private static final LocalTime END_OF_DAY = LocalTime.of(23, 59, 59);

    public MovieSessionDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MovieSession> criteriaQuery =
                    criteriaBuilder.createQuery(MovieSession.class);
            Root<MovieSession> root = criteriaQuery.from(MovieSession.class);
            Predicate moviePredicate = criteriaBuilder.equal(root.get("movie"), movieId);
            Predicate datePredicate = criteriaBuilder.between(root.get("showTime"),
                    date.atStartOfDay(), date.atTime(END_OF_DAY));
            Predicate allConditions = criteriaBuilder.and(moviePredicate, datePredicate);
            criteriaQuery.select(root).where(allConditions);
            root.fetch("movie");
            root.fetch("cinemaHall");
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get available sessions for movie with id: "
                    + movieId + " for date: " + date, e);
        }
    }

    @Override
    public Optional<MovieSession> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM MovieSession ms "
                            + "JOIN FETCH ms.movie "
                            + "JOIN FETCH ms.cinemaHall "
                            + "WHERE ms.id = :id", MovieSession.class).setParameter("id", id)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a movie session by id: " + id, e);
        }
    }

    @Override
    public Optional<MovieSession> update(Long id, MovieSession movieSession) {
        try (Session session = sessionFactory.openSession()) {
            MovieSession temp = session.get(MovieSession.class, id);
            temp.setShowTime(movieSession.getShowTime());
            temp.setMovie(movieSession.getMovie());
            temp.setCinemaHall(movieSession.getCinemaHall());
            session.update(temp);
            return Optional.ofNullable(temp);
        } catch (Exception e) {
            throw new DataProcessingException("Can't update a movie session by id: " + id, e);
        }
    }

    @Override
    public void delete(MovieSession movieSession) {
        try (Session session = sessionFactory.openSession()) {
            session.delete(movieSession);
        } catch (Exception e) {
            throw new DataProcessingException("Can't delete a movie session: " + movieSession, e);
        }
    }
}
