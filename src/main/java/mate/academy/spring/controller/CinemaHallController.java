package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.mapper.CinemaHallDtoMapper;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService service;
    private final CinemaHallDtoMapper dtoMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
            CinemaHallDtoMapper dtoMapper) {
        this.service = cinemaHallService;
        this.dtoMapper = dtoMapper;
    }
    
    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return service.getAll().stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
    }
    
    @PostMapping()
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHall) {
        return dtoMapper.toDto(service
                .add(dtoMapper.toModel(cinemaHall)));
    }
}
