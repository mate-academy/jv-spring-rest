package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallsRequestDto;
import mate.academy.spring.model.dto.CinemaHallsResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallsResponseDto parseToDto(CinemaHall cinemaHall) {
        CinemaHallsResponseDto responseDto = new CinemaHallsResponseDto();
        responseDto.setId(cinemaHall.getId());
        responseDto.setCapacity(cinemaHall.getCapacity());
        responseDto.setDescription(cinemaHall.getDescription());
        return responseDto;
    }

    public CinemaHall parseToModel(CinemaHallsRequestDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(requestDto.getDescription());
        cinemaHall.setCapacity(requestDto.getCapacity());
        return cinemaHall;
    }
}
