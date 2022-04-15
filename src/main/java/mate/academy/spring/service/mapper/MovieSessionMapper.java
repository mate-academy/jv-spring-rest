package mate.academy.spring.service.mapper;

import java.util.List;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieSessionMapper {

    @Mapping(target = "id", source = "movieSession.id")
    @Mapping(target = "movieId", source = "movieSession.movie.id")
    @Mapping(target = "cinemaHallId", source = "movieSession.cinemaHall.id")
    @Mapping(target = "showTime", source = "movieSession.showTime")
    MovieSessionResponseDto movieSessionToMovieSessionResponseDto(MovieSession movieSession);

    List<MovieSessionResponseDto> movieSessionListToResponseDtoList(List<MovieSession> list);
}
