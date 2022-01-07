package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/cinema_halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapper cinemaHallDtoMapper;

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto requestDto) {
        return cinemaHallDtoMapper
                .toDto(cinemaHallService.add(cinemaHallDtoMapper.toModel(requestDto)));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CinemaHallResponseDto get(@PathVariable Long id) {
        return cinemaHallDtoMapper.toDto(cinemaHallService.get(id));
    }
}
