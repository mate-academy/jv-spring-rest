package mate.academy.spring.dao;

public interface GenericDao<T> {
    T add(T entity);

    T update(T t);

    void delete(T t);
}
