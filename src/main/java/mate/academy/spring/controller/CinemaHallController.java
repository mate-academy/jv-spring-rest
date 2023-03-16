package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinemaHalls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapper cinemaHallDtoMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
    }

    @GetMapping("/")
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CinemaHallResponseDto get(@PathVariable Long id) {
        return cinemaHallDtoMapper.toDto(cinemaHallService.get(id));
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return cinemaHallDtoMapper
                .toDto(cinemaHallService.add(cinemaHallDtoMapper
                        .toModelRequest(cinemaHallRequestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cinemaHallService.delete(cinemaHallService.get(id));
    }

    @PutMapping("/{id}")
    public CinemaHallResponseDto update(@PathVariable Long id,
                                   @RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = cinemaHallDtoMapper.toModelRequest(cinemaHallRequestDto);
        cinemaHall.setId(id);
        CinemaHall updatedCinemaHall = cinemaHallService.update(cinemaHall);
        return cinemaHallDtoMapper.toDto(updatedCinemaHall);
    }
}
