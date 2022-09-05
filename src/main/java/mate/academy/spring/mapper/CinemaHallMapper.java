package mate.academy.spring.mapper;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;

public interface CinemaHallMapper extends
        Mapper<CinemaHallRequestDto, CinemaHallResponseDto, CinemaHall> {
}
