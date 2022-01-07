package mate.academy.spring.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.spring.dao.AbstractDao;

@AllArgsConstructor
public abstract class AbstractService<T> implements GenericService<T> {
    private final AbstractDao<T> abstractDao;
    //Experiment class, need mentor review!!!

    @Override
    public List<T> getAll() {
        return abstractDao.getAll();
    }

    @Override
    public T get(Long id) {
        return abstractDao.get(id).get();
    }

    @Override
    public T update(Long id) {
        return abstractDao.update(id).get();
    }

    @Override
    public void delete(Long id) {
        abstractDao.delete(id);
    }
}
