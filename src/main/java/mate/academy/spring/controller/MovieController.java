package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto movieRequestDto) {
        return movieMapper.toDto(movieService.add(movieMapper.toModel(movieRequestDto)));
    }

    @GetMapping("/inject")
    public String inject() {
        Movie movie1 = new Movie();
        movie1.setId(1L);
        movie1.setTitle("Movie1");
        movie1.setDescription("Description1");

        Movie movie2 = new Movie();
        movie2.setId(2L);
        movie2.setTitle("Movie2");
        movie2.setDescription("Description2");

        Movie movie3 = new Movie();
        movie3.setId(3L);
        movie3.setTitle("Movie3");
        movie3.setDescription("Description3");

        movieService.add(movie1);
        movieService.add(movie2);
        movieService.add(movie3);

        return "Done!";
    }

    @GetMapping("/{movieId}")
    public MovieResponseDto getById(@PathVariable Long movieId) {
        return movieMapper.toDto(movieService.get(movieId));
    }
}
