package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHall mapToModel(CinemaHallRequestDto dto) {
        CinemaHall model = new CinemaHall();
        model.setCapacity(dto.getCapacity());
        model.setDescription(dto.getDescription());
        return model;
    }

    public CinemaHallResponseDto mapToDto(CinemaHall model) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setId(model.getId());
        dto.setCapacity(model.getCapacity());
        dto.setDescription(model.getDescription());
        return dto;
    }
}
