package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto parse(CinemaHall cinemaHall) {
        CinemaHallResponseDto response = new CinemaHallResponseDto();
        response.setId(cinemaHall.getId());
        response.setDescription(cinemaHall.getDescription());
        response.setCapacity(cinemaHall.getCapacity());
        return response;
    }

    public CinemaHall toModel(CinemaHallRequestDto request) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(request.getCapacity());
        cinemaHall.setDescription(request.getDescription());
        return cinemaHall;
    }
}
