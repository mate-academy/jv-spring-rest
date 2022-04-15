package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponceDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponceDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponceDto responceDto = new CinemaHallResponceDto();
        responceDto.setId(cinemaHall.getId());
        responceDto.setCapacity(cinemaHall.getCapacity());
        responceDto.setDescription(cinemaHall.getDescription());
        return responceDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
