package mate.academy.spring.mapper.impl;

import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.mapper.CinemaHallResponseMapper;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallResponseMapperImpl implements CinemaHallResponseMapper {
    @Override
    public CinemaHallResponseDto toDto(CinemaHall model) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(model.getId());
        cinemaHallResponseDto.setCapacity(model.getCapacity());
        cinemaHallResponseDto.setDescription(model.getDescription());
        return cinemaHallResponseDto;
    }
}
