package mate.academy.spring.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallRequestMapper {
    public CinemaHall fromDto(CinemaHallRequestDto cinemaHallDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(cinemaHallDto.getDescription());
        cinemaHall.setCapacity(cinemaHallDto.getCapacity());
        return cinemaHall;
    }
}
