package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dao.CinemaHallService;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.mapper.CinemaHallMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private CinemaHallMapper cinemaHallMapper;
    private CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallMapper cinemaHallMapper,
                                CinemaHallService cinemaHallDao) {
        this.cinemaHallMapper = cinemaHallMapper;
        this.cinemaHallService = cinemaHallDao;
    }

    @PostMapping
    public CinemaHallResponseDto add(
            @RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return cinemaHallMapper.mapToDto(
                cinemaHallService.add(cinemaHallMapper.mapToModel(cinemaHallRequestDto)));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
