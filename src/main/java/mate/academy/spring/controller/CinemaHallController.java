package mate.academy.spring.controller;

import mate.academy.spring.mapper.CinemaHallMapper;
import mate.academy.spring.mapper.MovieMapper;
import mate.academy.spring.model.dto.request.CinemaHallRequestDto;
import mate.academy.spring.model.dto.request.MovieRequestDto;
import mate.academy.spring.model.dto.response.CinemaHallResponseDto;
import mate.academy.spring.model.dto.response.MovieResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapper cinemaHallMapper;

    public CinemaHallController(CinemaHallService cinemaHallService, CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }


    @GetMapping
    public List<CinemaHallResponseDto> getAllUsers() {
        return cinemaHallService
                .getAll()
                .stream()
                .map(cinemaHallMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto requestDto) {
        return cinemaHallMapper.parse(cinemaHallService.add(cinemaHallMapper.toModel(requestDto)));
    }
}
