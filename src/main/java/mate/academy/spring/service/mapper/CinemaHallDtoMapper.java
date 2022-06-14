package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallResponseDto parse(CinemaHall cinemaHall) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setId(cinemaHall.getId());
        dto.setDescription(cinemaHall.getDescription());
        dto.setCapacity(cinemaHall.getCapacity());
        return dto;
    }

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall model = new CinemaHall();
        model.setCapacity(cinemaHallRequestDto.getCapacity());
        model.setDescription(cinemaHallRequestDto.getDescription());
        return model;
    }
}
