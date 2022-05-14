package mate.academy.spring.mappers;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {

    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setId(cinemaHall.getId());
        dto.setDescription(cinemaHall.getDescription());
        dto.setCapacity(cinemaHall.getCapacity());
        return dto;
    }

    public CinemaHall fromDto(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(dto.getId());
        cinemaHall.setDescription(dto.getDescription());
        cinemaHall.setCapacity(dto.getCapacity());
        return cinemaHall;
    }
}
