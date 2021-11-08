package mate.academy.spring.controller;

import java.util.List;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper mapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper mapper) {
        this.movieService = movieService;
        this.mapper = mapper;
    }

    @GetMapping("/movies")
    public List<MovieResponseDto> getAll() {
        return mapper.movieListToResponseDtoList(movieService.getAll());
    }

    @PostMapping("/movies")
    public MovieResponseDto create(@RequestBody MovieRequestDto dto) {
        return mapper.movieToMovieResponseDto(movieService
                .add(mapper.movieRequestDtoToMovie(dto)));
    }
}
