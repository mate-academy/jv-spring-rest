package mate.academy.spring.mapper.impl;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.mapper.CinemaHallRequestMapper;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallRequestMapperImpl implements CinemaHallRequestMapper {

    @Override
    public CinemaHall toModel(CinemaHallRequestDto request) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(request.getCapacity());
        cinemaHall.setDescription(request.getDescription());
        return cinemaHall;
    }
}
