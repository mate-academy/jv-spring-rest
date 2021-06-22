package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto parseToDto(CinemaHall cinemaHall) {
        return new CinemaHallResponseDto(cinemaHall.getId(),
                cinemaHall.getCapacity(), cinemaHall.getDescription());
    }

    public CinemaHall parseToModel(CinemaHallRequestDto requestDto) {
        return new CinemaHall(requestDto.getCapacity(),
                requestDto.getDescription());
    }
}
