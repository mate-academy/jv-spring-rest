package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.request.CinemaHallRequestDto;
import mate.academy.spring.dto.response.CinemaHallResponseDto;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final DtoResponseMapper<CinemaHall, CinemaHallResponseDto> responseDtoMapper;
    private final DtoRequestMapper<CinemaHall, CinemaHallRequestDto> requestDtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                DtoResponseMapper<CinemaHall,
                                        CinemaHallResponseDto> responseDtoMapper,
                                DtoRequestMapper<CinemaHall,
                                        CinemaHallRequestDto> requestDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = cinemaHallService.add(requestDtoMapper.toModel(dto));
        return responseDtoMapper.toDto(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(responseDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
