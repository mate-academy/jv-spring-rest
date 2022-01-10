package mate.academy.spring.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.spring.dao.GenericDao;

@AllArgsConstructor
public abstract class AbstractService<T, C extends GenericDao<T>> implements GenericService<T> {
    private final C dao;
    //Experiment class, need mentor review!!!

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public T get(Long id) {
        return dao.get(id).get();
    }

    @Override
    public T update(Long id) {
        return dao.update(id).get();
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
