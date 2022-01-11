package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {

    public CinemaHallRequestDto toDto(CinemaHall cinemaHall) {
        CinemaHallRequestDto responseDto = new CinemaHallRequestDto();
        responseDto.setId(cinemaHall.getId());
        responseDto.setDescription(cinemaHall.getDescription());
        responseDto.setCapacity(cinemaHall.getCapacity());
        return responseDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
