package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallDtoMapper mapper;
    private final CinemaHallService service;

    @Autowired
    public CinemaHallController(CinemaHallDtoMapper mapper,
                                CinemaHallService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto requestDto) {
        return mapper.toDto(service.add(mapper.toModel(requestDto)));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return service.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
