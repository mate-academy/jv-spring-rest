package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper
        implements Mapper<CinemaHallRequestDto, CinemaHallResponseDto, CinemaHall> {

    @Override
    public CinemaHallResponseDto toDto(CinemaHall model) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(model.getId());
        cinemaHallResponseDto.setCapacity(model.getCapacity());
        cinemaHallResponseDto.setDescription(model.getDescription());
        return cinemaHallResponseDto;
    }

    @Override
    public CinemaHall toModel(CinemaHallRequestDto modelRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(modelRequestDto.getCapacity());
        cinemaHall.setDescription(modelRequestDto.getDescription());
        return cinemaHall;
    }
}
