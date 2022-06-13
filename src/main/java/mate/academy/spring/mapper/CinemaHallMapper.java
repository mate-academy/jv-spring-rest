package mate.academy.spring.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(cinemaHall.getId());
        responseDto.setCapacity(cinemaHall.getCapacity());
        responseDto.setDescription(cinemaHall.getDescription());
        return responseDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall requestModel = new CinemaHall();
        requestModel.setCapacity(cinemaHallRequestDto.getCapacity());
        requestModel.setDescription(cinemaHallRequestDto.getDescription());
        return requestModel;
    }
}
