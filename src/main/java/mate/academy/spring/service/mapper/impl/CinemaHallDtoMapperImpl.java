package mate.academy.spring.service.mapper.impl;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapperImpl implements CinemaHallDtoMapper {
    @Override
    public CinemaHallResponseDto parse(CinemaHall hall) {
        CinemaHallResponseDto hallResponseDto = new CinemaHallResponseDto();
        hallResponseDto.setId(hall.getId());
        hallResponseDto.setCapacity(hall.getCapacity());
        hallResponseDto.setDescription(hall.getDescription());
        return hallResponseDto;
    }

    @Override
    public CinemaHall toModel(CinemaHallRequestDto hallRequestDto) {
        CinemaHall hall = new CinemaHall();
        hall.setCapacity(hallRequestDto.getCapacity());
        hall.setDescription(hallRequestDto.getDescription());
        return hall;
    }
}
