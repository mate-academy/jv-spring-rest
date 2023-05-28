package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.request.RequestCinemaHall;
import mate.academy.spring.dto.response.ResponseCinemaHall;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper implements
        Mapper<CinemaHall, ResponseCinemaHall, RequestCinemaHall> {

    @Override
    public ResponseCinemaHall toDto(CinemaHall cinemaHall) {
        ResponseCinemaHall responseCinemaHallDto = new ResponseCinemaHall();
        responseCinemaHallDto.setId(cinemaHall.getId());
        responseCinemaHallDto.setDescription(cinemaHall.getDescription());
        responseCinemaHallDto.setCapacity(cinemaHall.getCapacity());
        return responseCinemaHallDto;
    }

    @Override
    public CinemaHall toModel(RequestCinemaHall requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestDto.getCapacity());
        cinemaHall.setDescription(requestDto.getDescription());
        return cinemaHall;
    }
}
