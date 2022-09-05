package mate.academy.spring.mapper.impl;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.mapper.CinemaHallMapper;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {
    @Override
    public CinemaHall toModel(CinemaHallRequestDto request) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(request.getCapacity());
        cinemaHall.setDescription(request.getDescription());
        return cinemaHall;
    }

    @Override
    public CinemaHallResponseDto toDto(CinemaHall entity) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(entity.getId());
        cinemaHallResponseDto.setCapacity(entity.getCapacity());
        cinemaHallResponseDto.setDescription(entity.getDescription());
        return cinemaHallResponseDto;
    }
}
