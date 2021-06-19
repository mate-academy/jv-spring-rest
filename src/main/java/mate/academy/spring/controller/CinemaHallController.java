package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapper cinemaHallMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return cinemaHallMapper.mapToDto(cinemaHallService
                .add(cinemaHallMapper.toModel(cinemaHallRequestDto)));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/inject")
    public String injectCinemaHall() {
        CinemaHall redCinemaHall = new CinemaHall();
        redCinemaHall.setCapacity(50);
        redCinemaHall.setDescription("Red cinema hall with comfy armchairs");
        cinemaHallService.add(redCinemaHall);

        CinemaHall greenCinemaHall = new CinemaHall();
        greenCinemaHall.setCapacity(50);
        greenCinemaHall.setDescription("Green cinema hall with big screen");
        cinemaHallService.add(greenCinemaHall);

        CinemaHall blueCinemaHall = new CinemaHall();
        blueCinemaHall.setCapacity(70);
        blueCinemaHall.setDescription("blue cinema hall with comfy armchairs, big screen and IMAX");
        cinemaHallService.add(blueCinemaHall);
        return "Added mock cinema halls to DB!";
    }
}
