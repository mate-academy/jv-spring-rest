package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mate.academy.spring.dto.request.MovieRequestDto;
import mate.academy.spring.dto.response.MovieResponseDto;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final MovieDtoMapper movieDtoMapper;

    @PostMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto requestDto) {
        Movie movie = movieDtoMapper.toModel(requestDto);
        return movieDtoMapper.toDto(movieService.add(movie));
    }

    @GetMapping
    public List<MovieResponseDto> findAll() {
        return movieService.getAll().stream()
                .map(movieDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
