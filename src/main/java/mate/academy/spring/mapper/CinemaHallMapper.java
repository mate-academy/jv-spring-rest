package mate.academy.spring.mapper;

import mate.academy.spring.dto.CinemaHallRequest;
import mate.academy.spring.dto.CinemaHallResponse;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponse parse(CinemaHall cinemaHall) {
        CinemaHallResponse cinemaHallResponse = new CinemaHallResponse();
        cinemaHallResponse.setId(cinemaHall.getId());
        cinemaHallResponse.setDescription(cinemaHall.getDescription());
        cinemaHallResponse.setCapacity(cinemaHall.getCapacity());
        return cinemaHallResponse;
    }

    public CinemaHall toModel(CinemaHallRequest cinemaHallRequest) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequest.getCapacity());
        cinemaHall.setDescription(cinemaHallRequest.getDescription());
        return cinemaHall;
    }
}
