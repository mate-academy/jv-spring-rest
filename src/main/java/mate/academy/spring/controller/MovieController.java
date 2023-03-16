package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movies")
@RestController
public class MovieController {
    private final MovieService movieService;

    private final MovieDtoMapper movieDtoMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieDtoMapper movieDtoMapper) {
        this.movieService = movieService;
        this.movieDtoMapper = movieDtoMapper;
    }

    @GetMapping("/{id}")
    public MovieResponseDto get(@PathVariable Long id) {
        return movieDtoMapper.toDto(movieService.get(id));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(movieDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto movieRequestDto) {
        return movieDtoMapper.toDto(movieService
                .add(movieDtoMapper.toModel(movieRequestDto)));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(movieService.get(id));
    }

    @PutMapping("/{id}")
    public MovieResponseDto update(@PathVariable Long id,
                                   @RequestBody MovieRequestDto movieRequestDto) {
        Movie movie = movieDtoMapper.toModel(movieRequestDto);
        movie.setId(id);
        Movie updatedMovie = movieService.update(movie);
        return movieDtoMapper.toDto(updatedMovie);
    }
}
