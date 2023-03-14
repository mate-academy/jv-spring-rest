package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.Movie;

public interface MovieDao extends GenericDao<Movie> {
    Optional<Movie> get(java.lang.Long id);

    List<Movie> getAll();
}
