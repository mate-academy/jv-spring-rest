package mate.academy.spring.service.mapper.impl;

import mate.academy.spring.dto.cinemahall.CinemaHallRequestDto;
import mate.academy.spring.dto.cinemahall.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.mapper.CinemaHallMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {

    @Override
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(cinemaHall.getId());
        responseDto.setDescription(cinemaHall.getDescription());
        responseDto.setCapacity(cinemaHall.getCapacity());
        return responseDto;
    }

    @Override
    public CinemaHall toModel(CinemaHallRequestDto requestDto) {
        CinemaHall hall = new CinemaHall();
        hall.setDescription(requestDto.getDescription());
        hall.setCapacity(hall.getCapacity());
        return hall;
    }
}
