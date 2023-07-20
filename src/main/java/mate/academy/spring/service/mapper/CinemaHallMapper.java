package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;

public class CinemaHallMapper {

    public CinemaHallResponseDto parseToResp(CinemaHall cinemaHall) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setId(cinemaHall.getId());
        dto.setCapacity(cinemaHall.getCapacity());
        dto.setDescription(cinemaHall.getDescription());
        return dto;
    }
}
