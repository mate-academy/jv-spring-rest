package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.impl.CinemaHallMapperImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapperImpl cinemaHallMapperImpl;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapperImpl cinemaHallMapperImpl) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapperImpl = cinemaHallMapperImpl;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService
                .getAll()
                .stream()
                .map(cinemaHallMapperImpl::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallResponseDto create(
            @RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = cinemaHallMapperImpl.toModel(cinemaHallRequestDto);
        return cinemaHallMapperImpl.toDto(cinemaHallService.add(cinemaHall));
    }
}
