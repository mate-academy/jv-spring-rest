package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto chrd = new CinemaHallResponseDto();
        chrd.setId(cinemaHall.getId());
        chrd.setCapacity(cinemaHall.getCapacity());
        chrd.setDescription(cinemaHall.getDescription());
        return chrd;
    }

    public CinemaHall toModel(CinemaHallRequestDto chrd) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(chrd.getCapacity());
        cinemaHall.setDescription(chrd.getDescription());
        return cinemaHall;
    }
}
