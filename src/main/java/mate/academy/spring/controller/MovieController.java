package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dao.MovieService;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieServise;
    private MovieMapper movieMapper;

    public MovieController(MovieService movieDao, MovieMapper movieMapper) {
        this.movieServise = movieDao;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto movieRequestDto) {
        return movieMapper.mapToDto(movieServise.add(
                movieMapper.mapToModel(movieRequestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieServise.getAll().stream()
                .map(movieMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
