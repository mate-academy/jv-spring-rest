package mate.academy.spring.dao;

import java.util.Optional;

public interface GenericDao<T> {
    T add(T entity);

    Optional<T> update(T entity);

    void delete(T entity);
}
