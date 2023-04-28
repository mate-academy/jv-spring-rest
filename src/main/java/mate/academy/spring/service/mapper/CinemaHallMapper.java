package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.RequestCinemaHallDto;
import mate.academy.spring.dto.ResponseCinemaHallDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public ResponseCinemaHallDto toDto(CinemaHall cinemaHall) {
        ResponseCinemaHallDto responseCinemaHallDto = new ResponseCinemaHallDto();
        responseCinemaHallDto.setId(cinemaHall.getId());
        responseCinemaHallDto.setCapacity(cinemaHall.getCapacity());
        responseCinemaHallDto.setDescription(cinemaHall.getDescription());
        return responseCinemaHallDto;
    }

    public CinemaHall toModel(RequestCinemaHallDto requestCinemaHallDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestCinemaHallDto.getCapacity());
        cinemaHall.setDescription(requestCinemaHallDto.getDescription());
        return cinemaHall;
    }
}
