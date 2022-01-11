package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        return CinemaHallResponseDto.builder()
                .id(cinemaHall.getId())
                .capacity(cinemaHall.getCapacity())
                .description(cinemaHall.getDescription())
                .build();
    }

    public CinemaHall toModel(CinemaHallRequestDto requestDto) {
        return CinemaHall.builder()
                .capacity(requestDto.getCapacity())
                .description(requestDto.getDescription())
                .build();
    }
}
