package mate.academy.spring.mapper;

import mate.academy.spring.dto.reques.CinemaHallRequestDto;
import mate.academy.spring.dto.response.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto parseToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallDto = new CinemaHallResponseDto();
        cinemaHallDto.setId(cinemaHall.getId());
        cinemaHallDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallDto.setDescription(cinemaHall.getDescription());
        return cinemaHallDto;
    }

    public CinemaHall parseToModel(CinemaHallRequestDto cinemaHallDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallDto.getCapacity());
        cinemaHall.setDescription(cinemaHallDto.getDescription());
        return cinemaHall;
    }
}
