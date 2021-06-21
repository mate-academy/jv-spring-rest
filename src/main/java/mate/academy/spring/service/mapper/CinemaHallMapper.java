package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallDto parseToDto(CinemaHall cinemaHall) {
        CinemaHallDto cinemaHallDto = new CinemaHallDto();
        cinemaHallDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallDto.setDescription(cinemaHall.getDescription());
        cinemaHallDto.setId(cinemaHall.getId());
        return cinemaHallDto;
    }

    public CinemaHall parseToModel(CinemaHallDto cinemaHallDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(cinemaHallDto.getId());
        cinemaHall.setDescription(cinemaHallDto.getDescription());
        cinemaHall.setCapacity(cinemaHallDto.getCapacity());
        return cinemaHall;
    }
}
