package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;

public interface CinemaHallDtoMapper {
    CinemaHallResponseDto toDto(CinemaHall cinemaHall);

    CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto);
}
