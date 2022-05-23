package mate.academy.spring.dao;

public interface GenericDao<T> {
    T add(T entity);

    T delete(T entity);

    void update(T entity);
}
