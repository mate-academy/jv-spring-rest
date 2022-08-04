package mate.academy.spring.model.mapper;

import mate.academy.spring.dto.RequestCinemaHallDto;
import mate.academy.spring.dto.ResponseCinemaHallDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public ResponseCinemaHallDto toDto(CinemaHall cinemaHall) {
        ResponseCinemaHallDto responseCinemaHallDto = new ResponseCinemaHallDto();
        responseCinemaHallDto.setDescription(cinemaHall.getDescription());
        responseCinemaHallDto.setId(cinemaHall.getId());
        responseCinemaHallDto.setCapacity(cinemaHall.getCapacity());
        return responseCinemaHallDto;
    }

    public CinemaHall toModel(RequestCinemaHallDto requestCinemaHallDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestCinemaHallDto.getCapacity());
        cinemaHall.setDescription(requestCinemaHallDto.getDescription());
        return cinemaHall;
    }
}
