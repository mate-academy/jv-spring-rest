package mate.academy.spring.controller;

import java.util.List;
import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallservice;
    private final CinemaHallDtoMapper cinemaHallDtoMapper;
    
    public CinemaHallController(CinemaHallService cinemaHallservice,
                                CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallservice = cinemaHallservice;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
    }
    
    @PostMapping
    public CinemaHallResponseDto save(CinemaHallRequestDto cinemaHall) {
        return cinemaHallDtoMapper
                .parse(cinemaHallservice.add(cinemaHallDtoMapper.toModel(cinemaHall)));
    }
    
    @GetMapping
    public List<CinemaHall> getAll() {
        return cinemaHallservice.getAll();
    }
}
