package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    List<T> getAll();

    T add(T entity);

    Optional<T> get(Long id);

    Optional<T> update(Long id);

    void delete(Long id);
}
