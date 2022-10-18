package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallDtoRequest;
import mate.academy.spring.model.dto.CinemaHallDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallDtoResponse toDto(CinemaHall cinemaHall) {
        CinemaHallDtoResponse cinemaHallDtoResponse = new CinemaHallDtoResponse();
        cinemaHallDtoResponse.setId(cinemaHall.getId());
        cinemaHallDtoResponse.setCapacity(cinemaHall.getCapacity());
        cinemaHallDtoResponse.setDescription(cinemaHall.getDescription());
        return cinemaHallDtoResponse;
    }

    public CinemaHall toModel(CinemaHallDtoRequest cinemaHallDtoRequest) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallDtoRequest.getCapacity());
        cinemaHall.setDescription(cinemaHallDtoRequest.getDescription());
        return cinemaHall;
    }
}
