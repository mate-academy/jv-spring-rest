package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.mapper.CinemaHallDtoMapper;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinemaHalls")
public class CinemaHallController {
    private CinemaHallService cinemaHallService;
    private CinemaHallDtoMapper mapper;

    public CinemaHallController(CinemaHallService cinemaHallService, CinemaHallDtoMapper mapper) {
        this.cinemaHallService = cinemaHallService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(mapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody
                                     CinemaHallRequestDto cinemaHallRequestDto) {
        System.out.println(cinemaHallRequestDto.getDescription());
        return mapper.parse(cinemaHallService.add(mapper.parse(cinemaHallRequestDto)));
    }
}
