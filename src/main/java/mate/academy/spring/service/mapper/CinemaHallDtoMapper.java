package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.request.CinemaHallRequestDto;
import mate.academy.spring.dto.response.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper
        implements GenericDtoMapper<CinemaHallRequestDto, CinemaHallResponseDto, CinemaHall> {

    @Override
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        return new CinemaHallResponseDto()
                .setId(cinemaHall.getId())
                .setCapacity(cinemaHall.getCapacity())
                .setDescription(cinemaHall.getDescription());
    }

    @Override
    public CinemaHall toModel(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }
}
