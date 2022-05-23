package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto toResponseDto(CinemaHall model) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(model.getId());
        responseDto.setCapacity(model.getCapacity());
        responseDto.setDescription(model.getDescription());
        return responseDto;
    }

    public CinemaHall toModel(CinemaHallRequestDto requestDto) {
        CinemaHall model = new CinemaHall();
        model.setCapacity(requestDto.getCapacity());
        model.setDescription(requestDto.getDescription());
        return model;
    }
}
