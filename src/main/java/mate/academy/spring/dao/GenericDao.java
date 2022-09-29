package mate.academy.spring.dao;

public interface GenericDao<T> {
    T add(T entity);

    void update(T entity);

    void delete(T entity);
}
