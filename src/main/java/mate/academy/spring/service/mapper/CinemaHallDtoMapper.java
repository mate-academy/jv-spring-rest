package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.cinemahalldto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.cinemahalldto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {

    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(cinemaHall.getId());
        responseDto.setCapacity(cinemaHall.getCapacity());
        responseDto.setDescription(cinemaHall.getDescription());
        return responseDto;
    }

    public CinemaHall toCinemaHall(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        return cinemaHall;
    }
}
