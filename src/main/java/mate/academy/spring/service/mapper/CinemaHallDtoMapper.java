package mate.academy.spring.service.mapper;

import org.springframework.stereotype.Component;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallResponseDto parse(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(cinemaHall.getId());
        cinemaHallResponseDto.setDescription(cinemaHall.getDescription());
        cinemaHallResponseDto.setCapacity(cinemaHall.getCapacity());
        return cinemaHallResponseDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(requestDto.getDescription());
        cinemaHall.setCapacity(requestDto.getCapacity());
        return cinemaHall;
    }
}
