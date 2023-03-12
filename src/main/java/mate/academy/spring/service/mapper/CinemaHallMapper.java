package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.dto.CinemaRequestDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto =
                new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(cinemaHall.getId());
        cinemaHallResponseDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallResponseDto.setDescription(cinemaHall.getDescription());
        return cinemaHallResponseDto;
    }

    public CinemaHall toModel(CinemaRequestDto cinemaRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaRequestDto.getDescription());
        return cinemaHall;

    }
}
