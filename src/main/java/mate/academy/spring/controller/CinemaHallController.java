package mate.academy.spring.controller;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CinemaHallController {
    private CinemaHallService cinemaHallService;
    private CinemaHallMapper cinemaHallMapper;

    @GetMapping("/cinema-halls")
    public CinemaHallRequestDto add(CinemaHallResponseDto response) {

        cinemaHallService.add();
    }

    @GetMapping("/cinema-halls")
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(c -> cinemaHallMapper.parseToResp(c))
                .collect(Collectors.toList());
    }
}
