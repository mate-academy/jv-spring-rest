package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.cinema.hall.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.cinema.hall.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        return new CinemaHall(cinemaHallRequestDto.getCapacity(),
                cinemaHallRequestDto.getDescription());
    }

    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        return new CinemaHallResponseDto(cinemaHall.getId(), cinemaHall.getCapacity(),
                cinemaHall.getDescription());
    }
}
