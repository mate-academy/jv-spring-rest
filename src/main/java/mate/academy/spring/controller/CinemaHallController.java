package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
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
    private final CinemaHallService hallService;
    private final CinemaHallDtoMapper hallDtoMapper;

    public CinemaHallController(CinemaHallService hallService,
                                CinemaHallDtoMapper hallDtoMapper) {
        this.hallService = hallService;
        this.hallDtoMapper = hallDtoMapper;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return hallService.getAll().stream()
                .map(hallDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto requestDto) {
        return hallDtoMapper.toDto(hallService.add(hallDtoMapper.toModel(requestDto)));
    }
}
