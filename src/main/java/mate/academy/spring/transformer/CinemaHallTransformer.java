package mate.academy.spring.transformer;

import mate.academy.spring.dto.CinemaHallDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallTransformer {

    public CinemaHallDto toDto(CinemaHall cinemaHall) {
        CinemaHallDto dto = new CinemaHallDto();
        dto.setId(cinemaHall.getId());
        dto.setDescription(cinemaHall.getDescription());
        dto.setCapacity(cinemaHall.getCapacity());
        return dto;
    }

    public CinemaHall fromDto(CinemaHallDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(dto.getId());
        cinemaHall.setDescription(dto.getDescription());
        cinemaHall.setCapacity(dto.getCapacity());
        return cinemaHall;
    }
}
