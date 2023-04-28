package mate.academy.spring.controller;

import java.util.List;
import mate.academy.spring.dto.request.CinemaHallRequestDto;
import mate.academy.spring.dto.responce.CinemaHallResponseDto;
import mate.academy.spring.mapper.Mapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;
    private final Mapper<CinemaHallRequestDto, CinemaHall> requestMapper;
    private final Mapper<CinemaHall, CinemaHallResponseDto> responseMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                Mapper<CinemaHallRequestDto, CinemaHall> requestMapper,
                                Mapper<CinemaHall, CinemaHallResponseDto> responseMapper) {
        this.cinemaHallService = cinemaHallService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto dto) {
        return responseMapper.map(cinemaHallService.add(requestMapper.map(dto)));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return responseMapper.mapAll(cinemaHallService.getAll());
    }
}
