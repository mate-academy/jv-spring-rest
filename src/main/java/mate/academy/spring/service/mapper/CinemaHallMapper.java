package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.cinemahall.CinemaHallRequestDto;
import mate.academy.spring.model.dto.cinemahall.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {

    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallDto = new CinemaHallResponseDto();
        cinemaHallDto.setId(cinemaHall.getId());
        cinemaHallDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallDto.setDescription(cinemaHall.getDescription());
        return cinemaHallDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallDto.getCapacity());
        cinemaHall.setDescription(cinemaHallDto.getDescription());
        return cinemaHall;
    }
}
