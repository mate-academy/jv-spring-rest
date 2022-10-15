package mate.academy.spring.mapper;

import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {

    public CinemaHall toModel(CinemaHallResponseDto responseDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(responseDto.getId());
        cinemaHall.setCapacity(responseDto.getCapacity());
        cinemaHall.setDescription(responseDto.getDescription());
        return cinemaHall;
    }

    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(cinemaHall.getId());
        responseDto.setCapacity(cinemaHall.getCapacity());
        responseDto.setDescription(cinemaHall.getDescription());
        return responseDto;
    }
}
