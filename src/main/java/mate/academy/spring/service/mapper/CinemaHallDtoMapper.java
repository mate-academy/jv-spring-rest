package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHall fromReqDto(CinemaHallRequestDto reqDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(reqDto.getCapacity());
        cinemaHall.setDescription(reqDto.getDescription());
        return cinemaHall;
    }

    public CinemaHallResponseDto toRespDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto respDto = new CinemaHallResponseDto();
        respDto.setId(cinemaHall.getId());
        respDto.setCapacity(cinemaHall.getCapacity());
        respDto.setDescription(cinemaHall.getDescription());
        return respDto;
    }
}
