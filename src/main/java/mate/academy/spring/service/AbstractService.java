package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.dao.GenericDao;

public abstract class AbstractService<T, C extends GenericDao<T>> implements GenericService<T> {
    private final Class<T> type;
    private final C dao;

    public AbstractService(Class<T> type, C dao) {
        this.type = type;
        this.dao = dao;
    }
    //Experiment class, need mentor review!!!

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public T get(Long id) {
        return dao.get(id).orElseThrow(()
                -> new RuntimeException(type.getName() + " not found"));
    }

    @Override
    public T update(Long id) {
        return dao.update(id).orElseThrow(()
                -> new RuntimeException(type.getName() + " not found"));
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
