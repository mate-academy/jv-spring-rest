package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.transformer.CinemaHallTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cinema-halls")
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;
    private final CinemaHallTransformer cinemaHallTransformer;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService, CinemaHallTransformer cinemaHallTransformer) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallTransformer = cinemaHallTransformer;
    }

    @PostMapping
    public void add(@RequestBody CinemaHallDto cinemaHallDto) {
        CinemaHall cinemaHall = cinemaHallTransformer.fromDto(cinemaHallDto);
        cinemaHallService.add(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallDto> getAll() {
        return cinemaHallService.getAll()
            .stream()
            .map(cinemaHallTransformer::toDto)
            .collect(Collectors.toList());
    }
}
