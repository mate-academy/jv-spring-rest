package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.requests.CinemaHallDtoRequest;
import mate.academy.spring.dto.responses.CinemaHallDtoResponse;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallDtoResponse toDto(CinemaHall cinemaHall) {
        CinemaHallDtoResponse cinemaHallDtoResponse = new CinemaHallDtoResponse();
        cinemaHallDtoResponse.setId(cinemaHall.getId());
        cinemaHallDtoResponse.setDescription(cinemaHallDtoResponse.getDescription());
        cinemaHallDtoResponse.setCapacity(cinemaHall.getCapacity());
        return cinemaHallDtoResponse;
    }

    public CinemaHall toModel(CinemaHallDtoRequest cinemaHallDtoRequest) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallDtoRequest.getCapacity());
        cinemaHall.setDescription(cinemaHallDtoRequest.getDescription());
        return cinemaHall;
    }
}
