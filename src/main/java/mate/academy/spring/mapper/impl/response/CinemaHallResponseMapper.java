package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.dto.response.CinemaHallResponseDto;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallResponseMapper
        implements DtoResponseMapper<CinemaHall, CinemaHallResponseDto> {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setId(cinemaHall.getId());
        dto.setCapacity(cinemaHall.getCapacity());
        dto.setDescription(cinemaHall.getDescription());
        return dto;
    }
}
