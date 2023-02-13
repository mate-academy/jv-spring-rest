package mate.academy.spring.model.dto.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {

    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        Long id = cinemaHall.getId();
        int capacity = cinemaHall.getCapacity();
        String description = cinemaHall.getDescription();
        return new CinemaHallResponseDto(id, capacity, description);
    }

    public CinemaHall toModel(CinemaHallRequestDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestDto.capacity());
        cinemaHall.setDescription(requestDto.description());
        return cinemaHall;
    }
}
