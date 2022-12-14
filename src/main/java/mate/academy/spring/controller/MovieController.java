package mate.academy.spring.controller;

import mate.academy.spring.dao.MovieDao;
import mate.academy.spring.dto.movie.MovieRequestDto;
import mate.academy.spring.dto.movie.MovieResponseDto;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieMapper movieMapper;
    private final MovieDao movieDao;

    public MovieController(MovieMapper movieMapper, MovieDao movieDao) {
        this.movieMapper = movieMapper;
        this.movieDao = movieDao;
    }

    @GetMapping("")
    public List<MovieResponseDto> getAll() {
        return movieDao.getAll().stream().map(movieMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto requestDto) {
        Movie movie = movieMapper.toModel(requestDto);
        Movie addedMovie = movieDao.add(movie);
        return movieMapper.toDto(addedMovie);
    }
}
