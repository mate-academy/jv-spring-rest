package mate.academy.spring.mapper;

import mate.academy.spring.dto.request.CinemaHallRequestDto;
import mate.academy.spring.dto.response.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(cinemaHall.getId());
        responseDto.setDescription(cinemaHall.getDescription());
        responseDto.setCapacity(cinemaHall.getCapacity());
        return responseDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        return cinemaHall;
    }
}
