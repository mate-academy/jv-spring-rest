package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dao.CinemaHallDao;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallDao cinemaHallDao;
    private final CinemaHallDtoMapper cinemaHallDtoMapper;

    @Autowired
    public CinemaHallController(CinemaHallDao cinemaHallDao,
                                CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallDao = cinemaHallDao;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallDao.getAll().stream()
                .map(cinemaHallDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return cinemaHallDtoMapper.toDto(
                cinemaHallDao.add(cinemaHallDtoMapper.toModel(cinemaHallRequestDto)));
    }
}
