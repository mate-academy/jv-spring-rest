package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallDto parse(CinemaHall cinemaHall) {
        CinemaHallDto cinemaHallDto = new CinemaHallDto();
        cinemaHallDto.setId(cinemaHall.getId());
        cinemaHallDto.setDescription(cinemaHall.getDescription());
        cinemaHallDto.setCapacity(cinemaHall.getCapacity());
        return cinemaHallDto;
    }

    public CinemaHall toModel(CinemaHallDto cinemaHallDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(cinemaHallDto.getId());
        cinemaHall.setDescription(cinemaHallDto.getDescription());
        cinemaHall.setCapacity(cinemaHallDto.getCapacity());
        return cinemaHall;
    }
}
