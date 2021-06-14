package mate.academy.spring.service.mapper.impl;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.mapper.CinemaHallMapper;

public class CinemaHallMapperImpl implements CinemaHallMapper {
    @Override
    public CinemaHallResponseDto parseIntoDto(CinemaHall cinemaHall) {
        return new CinemaHallResponseDto(cinemaHall.getId(),
                cinemaHall.getCapacity(),
                cinemaHall.getDescription());
    }

    @Override
    public CinemaHall parseFromDto(CinemaHallRequestDto cinemaHallRequestDto) {
        return new CinemaHall(cinemaHallRequestDto.getCapacity(),
                cinemaHallRequestDto.getDescription());
    }
}
