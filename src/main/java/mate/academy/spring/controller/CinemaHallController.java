package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.impl.CinemaHallDtoMapperImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
@AllArgsConstructor
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapperImpl cinemaHallMapper;

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::parse).collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = cinemaHallMapper.toModel(cinemaHallRequestDto);
        return cinemaHallMapper.parse(cinemaHallService.add(cinemaHall));
    }
}
