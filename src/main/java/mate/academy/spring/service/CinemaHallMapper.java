package mate.academy.spring.service;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;

public interface CinemaHallMapper {
    CinemaHallResponseDto toDto(CinemaHall cinemaHall);

    CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto);
}
