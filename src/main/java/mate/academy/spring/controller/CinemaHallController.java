package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallsRequestDto;
import mate.academy.spring.model.dto.CinemaHallsResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapper cinemaHallsDtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper cinemaHallsDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallsDtoMapper = cinemaHallsDtoMapper;
    }

    @GetMapping
    public List<CinemaHallsResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallsDtoMapper::parseToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallsResponseDto add(@RequestBody CinemaHallsRequestDto requestDto) {
        return cinemaHallsDtoMapper
                .parseToDto(cinemaHallService.add(cinemaHallsDtoMapper.parseToModel(requestDto)));
    }
}
