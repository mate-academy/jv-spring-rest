package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto parse(CinemaHall cinemaHall) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setDescription(cinemaHall.getDescription());
        responseDto.setCapacity(cinemaHall.getCapacity());
        responseDto.setId(cinemaHall.getId());
        return responseDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestDto.getCapacity());
        cinemaHall.setDescription(cinemaHall.getDescription());
        return cinemaHall;
    }
}
