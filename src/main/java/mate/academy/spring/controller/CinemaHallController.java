package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private CinemaHallService cinemaHallService;
    private CinemaHallMapper mapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService, CinemaHallMapper mapper) {
        this.cinemaHallService = cinemaHallService;
        this.mapper = mapper;
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto requestDto) {
        CinemaHall createdModel = cinemaHallService.add(mapper.toModel(requestDto));
        return mapper.toResponseDto(createdModel);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
