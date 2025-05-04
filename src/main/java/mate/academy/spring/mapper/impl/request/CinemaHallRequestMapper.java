package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.dto.request.CinemaHallRequestDto;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallRequestMapper
        implements DtoRequestMapper<CinemaHall, CinemaHallRequestDto> {
    @Override
    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
