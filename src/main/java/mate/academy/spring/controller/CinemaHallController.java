package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaDtoHallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema_halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaDtoHallMapper cinemaDtoHallMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaDtoHallMapper cinemaDtoHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaDtoHallMapper = cinemaDtoHallMapper;
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody
                                            CinemaHallRequestDto requestDto) {
        return cinemaDtoHallMapper.parse(cinemaHallService
                .add(cinemaDtoHallMapper.toModel(requestDto)));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
                .stream().map(cinemaDtoHallMapper::parse)
                .collect(Collectors.toList());
    }
}
