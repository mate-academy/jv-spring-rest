package mate.academy.spring.mapper.responce;

import mate.academy.spring.dto.responce.CinemaHallResponseDto;
import mate.academy.spring.mapper.Mapper;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallResponseDtoMapper implements Mapper<CinemaHall, CinemaHallResponseDto> {
    @Override
    public CinemaHallResponseDto map(CinemaHall input) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(input.getId());
        cinemaHallResponseDto.setDescription(input.getDescription());
        cinemaHallResponseDto.setCapacity(input.getCapacity());
        return cinemaHallResponseDto;
    }
}
