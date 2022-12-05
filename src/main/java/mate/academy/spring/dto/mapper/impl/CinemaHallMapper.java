package mate.academy.spring.dto.mapper.impl;

import mate.academy.spring.dto.CinemaHallDto;
import mate.academy.spring.dto.mapper.DtoMapper;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper implements DtoMapper<CinemaHall, CinemaHallDto> {
    public CinemaHallDto toDto(CinemaHall cinemaHall) {
        CinemaHallDto dto = new CinemaHallDto();
        dto.setId(cinemaHall.getId());
        dto.setCapacity(cinemaHall.getCapacity());
        dto.setDescription(cinemaHall.getDescription());
        return dto;
    }

    public CinemaHall toModel(CinemaHallDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(dto.getCapacity());
        cinemaHall.setDescription(dto.getDescription());
        return cinemaHall;
    }
}
