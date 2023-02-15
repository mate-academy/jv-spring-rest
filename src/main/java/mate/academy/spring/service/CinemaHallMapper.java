package mate.academy.spring.service;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;

public interface CinemaHallMapper {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall);

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto);
}
