package mate.academy.spring.security.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallResponseDto parse(CinemaHall cinemaHall) {
        CinemaHallResponseDto response = new CinemaHallResponseDto();
        response.setId(cinemaHall.getId());
        response.setCapacity(cinemaHall.getCapacity());
        response.setDescription(cinemaHall.getDescription());
        return response;
    }

    public CinemaHall toCinemaHall(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}

