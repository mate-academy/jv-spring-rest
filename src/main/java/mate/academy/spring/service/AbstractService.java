package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.dao.GenericDao;

public abstract class AbstractService<T, D extends GenericDao<T>> implements GenericService<T> {
    private final Class<T> type;
    private final D dao;

    public AbstractService(Class<T> type, D dao) {
        this.type = type;
        this.dao = dao;
    }

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
