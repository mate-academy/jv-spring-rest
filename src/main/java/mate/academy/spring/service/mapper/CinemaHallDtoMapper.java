package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto hallResponseDto = new CinemaHallResponseDto();
        hallResponseDto.setId(cinemaHall.getId());
        hallResponseDto.setCapacity(cinemaHall.getCapacity());
        hallResponseDto.setDescription(cinemaHall.getDescription());
        return hallResponseDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto requestDto) {
        CinemaHall hall = new CinemaHall();
        hall.setCapacity(requestDto.getCapacity());
        hall.setDescription(requestDto.getDescription());
        return hall;
    }
}
