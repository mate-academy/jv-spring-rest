package mate.academy.spring.service.impl;

import java.util.List;
import mate.academy.spring.dao.MovieServise;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieServise movieDao;

    public MovieServiceImpl(MovieServise movieDao) {
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
