package mate.academy.spring.dao;

public interface GenericDao<T> {
    T add(T entity);

    void remove(T entity);
}
