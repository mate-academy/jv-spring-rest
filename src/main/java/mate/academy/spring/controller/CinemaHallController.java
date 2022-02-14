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
    private CinemaHallService cinemaHallService;
    private CinemaHallDtoMapper cinemaHallDtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
    }

    @GetMapping("/")
    public List<CinemaHallResponseDto> getAll() {
        System.out.println(cinemaHallService.getAll());
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto cinemaHall) {
        return cinemaHallDtoMapper.parse(cinemaHallService.add(cinemaHallDtoMapper
                .toModel(cinemaHall)));
    }

    @GetMapping("/inject")
    public String injectMockData() {
        CinemaHall firstCinemaHall = new CinemaHall();
        firstCinemaHall.setCapacity(100);
        firstCinemaHall.setDescription("first hall with capacity 100");
        CinemaHall secondCinemaHall = new CinemaHall();
        secondCinemaHall.setCapacity(200);
        secondCinemaHall.setDescription("second hall with capacity 200");
        CinemaHall greenCinemaHall = new CinemaHall();
        greenCinemaHall.setDescription("Green hall for 49 seats, "
                + "which give you an unforgettable journey into the 3D world of cinema");
        greenCinemaHall.setCapacity(225);
        CinemaHall redCinemaHall = new CinemaHall();
        redCinemaHall.setDescription("64 channels and special geometry"
                + " of the hall guarantee the accuracy of sound "
                + "positioning and the effect of presence");
        redCinemaHall.setCapacity(285);

        cinemaHallService.add(firstCinemaHall);
        cinemaHallService.add(secondCinemaHall);
        cinemaHallService.add(greenCinemaHall);
        cinemaHallService.add(redCinemaHall);
        return "Done!";
    }
}
