package mate.academy.spring.service.mapper;

import java.util.List;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CinemaHallMapper {

    @Mapping(target = "id", source = "cinemaHall.id")
    @Mapping(target = "capacity", source = "cinemaHall.capacity")
    @Mapping(target = "description", source = "cinemaHall.description")
    CinemaHallResponseDto cinemaHallToResponseDto(CinemaHall cinemaHall);

    @Mapping(target = "capacity", source = "dto.capacity")
    @Mapping(target = "description", source = "dto.description")
    CinemaHall cinemaHallRequestDtoToCinemaHall(CinemaHallRequestDto dto);

    List<CinemaHallResponseDto> cinemaHallListToResponseDtoList(List<CinemaHall> list);
}
