package mate.academy.spring.service.dtomapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(cinemaHall.getId());
        cinemaHallResponseDto.setDescription(cinemaHallResponseDto.getDescription());
        cinemaHallResponseDto.setCapacity(cinemaHallResponseDto.getCapacity());
        return cinemaHallResponseDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto hallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(hallRequestDto.getCapacity());
        cinemaHall.setDescription(hallRequestDto.getDescription());
        return cinemaHall;
    }
}
