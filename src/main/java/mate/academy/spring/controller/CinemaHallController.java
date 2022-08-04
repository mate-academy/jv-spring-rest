package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapping.CinemaHallDtoMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinemaHalls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapping cinemaHallDtoMapping;

    @Autowired
    public CinemaHallController (CinemaHallService cinemaHallService,
                                 CinemaHallDtoMapping cinemaHallDtoMapping) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoMapping = cinemaHallDtoMapping;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoMapping::parseToDto)
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CinemaHallResponseDto put(@RequestBody CinemaHallRequestDto request) {
        CinemaHall cinemaHall = cinemaHallService.add(cinemaHallDtoMapping.parseToModel(request));
        return cinemaHallDtoMapping.parseToDto(cinemaHall);
    }
}
