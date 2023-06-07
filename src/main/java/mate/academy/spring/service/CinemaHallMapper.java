package mate.academy.spring.service;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;

public interface CinemaHallMapper {
    CinemaHallResponseDto toDto(CinemaHall cinemaHall);

    CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto);
}
