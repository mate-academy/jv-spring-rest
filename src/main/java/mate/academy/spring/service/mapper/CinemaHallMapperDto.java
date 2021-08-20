package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperDto {
    public CinemaHallResponseDto parse(CinemaHall hall) {
        return new CinemaHallResponseDto(hall.getId(), hall.getCapacity(), hall.getDescription());
    }

    public CinemaHall toModel(CinemaHallRequestDto req) {
        return new CinemaHall(req.getCapacity(), req.getDescription());
    }
}
