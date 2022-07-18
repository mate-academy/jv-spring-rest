package mate.academy.spring.service.impl;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {
    @Override
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setId(cinemaHall.getId());
        dto.setDescription(cinemaHall.getDescription());
        dto.setCapacity(cinemaHall.getCapacity());
        return dto;
    }

    @Override
    public CinemaHall toModel(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(dto.getCapacity());
        cinemaHall.setDescription(dto.getDescription());
        return cinemaHall;
    }
}
