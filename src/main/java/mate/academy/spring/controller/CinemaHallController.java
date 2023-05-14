package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private CinemaDtoMapper cinemaDtoMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaDtoMapper cinemaDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaDtoMapper = cinemaDtoMapper;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll()
                .stream()
                .map(CinemaDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return CinemaDtoMapper.toDto(cinemaHallService.add(cinemaDtoMapper
                .toModel(cinemaHallRequestDto)));
    }
}
