package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto modelToResponse(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setDescription(cinemaHall.getDescription());
        cinemaHallResponseDto.setCapacity(cinemaHall.getCapacity());
        return cinemaHallResponseDto;
    }

    public CinemaHall requestToModel(CinemaHallRequestDto cinemaHallRequestDtoDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(cinemaHallRequestDtoDto.getId());
        cinemaHall.setDescription(cinemaHallRequestDtoDto.getDescription());
        cinemaHall.setCapacity(cinemaHallRequestDtoDto.getCapacity());
        return cinemaHall;
    }
}
