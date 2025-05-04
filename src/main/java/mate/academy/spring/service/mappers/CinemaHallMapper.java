package mate.academy.spring.service.mappers;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.dto.CinemaHallRequestDto;
import mate.academy.spring.service.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto parseEntityToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallResponseDto.setId(cinemaHall.getId());
        cinemaHallResponseDto.setDescription(cinemaHall.getDescription());
        return cinemaHallResponseDto;
    }

    public CinemaHall parseDtoToEntity(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
