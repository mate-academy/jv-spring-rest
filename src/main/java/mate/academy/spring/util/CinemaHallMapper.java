package mate.academy.spring.util;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto responseCinemaHallDto = new CinemaHallResponseDto();
        responseCinemaHallDto.setId(cinemaHall.getId());
        responseCinemaHallDto.setCapacity(cinemaHall.getCapacity());
        responseCinemaHallDto.setDescription(cinemaHall.getDescription());
        return responseCinemaHallDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
