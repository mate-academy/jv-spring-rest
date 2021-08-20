package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperDto {
    public CinemaHallResponseDto toDto(CinemaHall hall) {
        return new CinemaHallResponseDto(hall.getId(), hall.getCapacity(), hall.getDescription());
    }

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        return new CinemaHall(cinemaHallRequestDto.getCapacity(), cinemaHallRequestDto.getDescription());
    }
}
