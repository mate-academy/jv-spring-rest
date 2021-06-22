package mate.academy.spring.service.impl;

import java.util.List;
import mate.academy.spring.dao.MovieService;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements mate.academy.spring.service.MovieService {
    private final MovieService movieDao;

    public MovieServiceImpl(MovieService movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).get();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
