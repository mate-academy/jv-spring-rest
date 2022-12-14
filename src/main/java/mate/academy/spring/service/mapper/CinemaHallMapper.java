package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.cinemahall.CinemaHallRequestDto;
import mate.academy.spring.dto.cinemahall.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;

public interface CinemaHallMapper {
    CinemaHallResponseDto toDto(CinemaHall cinemaHall);

    CinemaHall toModel(CinemaHallRequestDto requestDto);
}
