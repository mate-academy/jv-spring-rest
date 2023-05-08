package mate.academy.spring.mapper.request;

import mate.academy.spring.dto.request.CinemaHallRequestDto;
import mate.academy.spring.mapper.Mapper;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallRequestDtoMapper implements Mapper<CinemaHallRequestDto, CinemaHall> {
    @Override
    public CinemaHall map(CinemaHallRequestDto input) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(input.getDescription());
        cinemaHall.setCapacity(input.getCapacity());
        return cinemaHall;
    }
}
