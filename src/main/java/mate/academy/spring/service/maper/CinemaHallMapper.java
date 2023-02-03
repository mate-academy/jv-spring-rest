package mate.academy.spring.service.maper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequest;
import mate.academy.spring.model.dto.CinemaHallResponse;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {

    public CinemaHallResponse toDto(CinemaHall cinemaHall) {
        CinemaHallResponse cinemaHallResponse = new CinemaHallResponse();
        cinemaHallResponse.setId(cinemaHall.getId());
        cinemaHallResponse.setDescription(cinemaHall.getDescription());
        cinemaHallResponse.setCapacity(cinemaHall.getCapacity());
        return cinemaHallResponse;
    }

    public CinemaHall toModel(CinemaHallRequest cinemaHallResponse) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallResponse.getCapacity());
        cinemaHall.setDescription(cinemaHallResponse.getDescription());
        return cinemaHall;
    }
}
