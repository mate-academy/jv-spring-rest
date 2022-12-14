package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;

public interface CinemaHallMapper {
    CinemaHallResponseDto toDto(CinemaHall cinemaHall);

    CinemaHall toModel(CinemaHallRequestDto requestDto);
}
