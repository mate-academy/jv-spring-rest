package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class AbstractDao<T> implements GenericDao<T> {
    protected final SessionFactory sessionFactory;
    private final Class<T> type;

    public AbstractDao(SessionFactory sessionFactory, Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    @Override
    public T add(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert " + type.getSimpleName()
                    + ": " + entity, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<T> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(type);
            criteriaQuery.from(type);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(type.getName() + " not found", e);
        }
    }

    @Override
    public Optional<T> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(type, id));
        } catch (Exception e) {
            throw new RuntimeException("Can't get " + type.getSimpleName() + " by id: " + id, e);
        }
    }

    @Override
    public Optional<T> update(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(session.get(type, id));
            transaction.commit();
            return Optional.ofNullable((T) session.get(type, id));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't update "
                    + type.getSimpleName() + " by id: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(session.get(type, id));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't delete "
                    + type.getSimpleName() + " by id: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
