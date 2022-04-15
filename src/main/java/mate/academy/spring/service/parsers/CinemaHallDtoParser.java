package mate.academy.spring.service.parsers;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.request.CinemaHallRequestDto;
import mate.academy.spring.model.dto.response.CinemaHallResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallDtoParser {

    public CinemaHall parseRequestToEntity(CinemaHallRequestDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestDto.getCapacity());
        cinemaHall.setDescription(requestDto.getDescription());
        return cinemaHall;
    }

    public CinemaHallResponseDto parseEntityToResponse(CinemaHall entity) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(entity.getId());
        cinemaHallResponseDto.setCapacity(entity.getCapacity());
        cinemaHallResponseDto.setDescription(entity.getDescription());
        return cinemaHallResponseDto;
    }
}
