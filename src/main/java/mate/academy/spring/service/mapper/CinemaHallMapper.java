package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponceDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponceDto parseToDto(CinemaHall cinemaHall) {
        CinemaHallResponceDto cinemaHallResponceDto = new CinemaHallResponceDto();
        cinemaHallResponceDto.setId(cinemaHall.getId());
        cinemaHallResponceDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallResponceDto.setDescription(cinemaHall.getDescription());
        return cinemaHallResponceDto;
    }

    public CinemaHall parseToModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
