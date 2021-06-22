package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapper cinemaHallDtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
    }

    @GetMapping("/")
    public List<CinemaHallResponseDto> get() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoMapper::parseToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/inject")
    public String injectMockData() {
        CinemaHall redHall = new CinemaHall();
        redHall.setCapacity(25);
        redHall.setDescription("little hall");

        CinemaHall greenHall = new CinemaHall();
        greenHall.setCapacity(50);
        greenHall.setDescription("middle hall");

        CinemaHall orangeHall = new CinemaHall();
        orangeHall.setCapacity(100);
        orangeHall.setDescription("big hall");

        cinemaHallService.add(redHall);
        cinemaHallService.add(greenHall);
        cinemaHallService.add(orangeHall);
        return "Done!";
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto cinema) {
        return cinemaHallDtoMapper.parseToDto(cinemaHallService
                .add(cinemaHallDtoMapper.toModel(cinema)));
    }
}
