package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaDtoMapper {
    public CinemaHallResponseDto parse(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallRequestDto = new CinemaHallResponseDto();
        cinemaHallRequestDto.setId(cinemaHall.getId());
        cinemaHallRequestDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallRequestDto.setDescription(cinemaHall.getDescription());
        return cinemaHallRequestDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
