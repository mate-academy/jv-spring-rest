package mate.academy.spring.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto parse(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDtoDto = new CinemaHallResponseDto();
        cinemaHallResponseDtoDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallResponseDtoDto.setDescription(cinemaHall.getDescription());
        cinemaHallResponseDtoDto.setId(cinemaHall.getId());
        return cinemaHallResponseDtoDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestDto.getCapacity());
        cinemaHall.setDescription(requestDto.getDescription());
        return cinemaHall;
    }
}
