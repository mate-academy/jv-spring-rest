package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto toDto(CinemaHall hall) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(hall.getId());
        responseDto.setCapacity(hall.getCapacity());
        responseDto.setDescription(hall.getDescription());
        return responseDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestDto.getCapacity());
        cinemaHall.setDescription(requestDto.getDescription());
        return cinemaHall;
    }
}
