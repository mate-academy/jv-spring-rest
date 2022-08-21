package mate.academy.spring.controller;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class CinemaHallController {
    CinemaHallService cinemaHallService;
    CinemaHallResponseDto cinemaHallResponseDto;
    CinemaHallRequestDto cinemaHallRequestDto;
    CinemaHallDtoMapper cinemaHallDtoMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallResponseDto cinemaHallResponseDto,
                                CinemaHallRequestDto cinemaHallRequestDto,
                                CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallResponseDto = cinemaHallResponseDto;
        this.cinemaHallRequestDto = cinemaHallRequestDto;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;

    }

    @PostMapping("/cinema-halls")
    @ResponseBody
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return cinemaHallDtoMapper
                .parse(cinemaHallService.add(cinemaHallDtoMapper.toModel(cinemaHallRequestDto)));
    }

    @GetMapping("/cinema-halls")
    @ResponseBody
    public List<CinemaHallResponseDto> get() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoMapper::parse).collect(Collectors.toList());
    }
}
