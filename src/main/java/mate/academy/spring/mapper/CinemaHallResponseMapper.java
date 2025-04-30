package mate.academy.spring.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallResponseMapper {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(cinemaHall.getId());
        cinemaHallResponseDto.setDescription(cinemaHall.getDescription());
        cinemaHallResponseDto.setCapacity(cinemaHall.getCapacity());
        return cinemaHallResponseDto;
    }
}
