package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHalRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallResponseDto parse(CinemaHall cinemaHall) {
        return new CinemaHallResponseDto(cinemaHall.getId(), cinemaHall.getCapacity(),
                cinemaHall.getDescription());
    }

    public CinemaHall toHall(CinemaHalRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(dto.getCapacity());
        cinemaHall.setDescription(dto.getDescription());
        return cinemaHall;
    }
}
