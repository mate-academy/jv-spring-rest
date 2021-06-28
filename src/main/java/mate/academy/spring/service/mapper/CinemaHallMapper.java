package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.requests.CinemaHallRequestDto;
import mate.academy.spring.model.dto.responses.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto parseToResponseDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(cinemaHall.getId());
        cinemaHallResponseDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallResponseDto.setDescription(cinemaHall.getDescription());
        return cinemaHallResponseDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
