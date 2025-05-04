package mate.academy.spring.mapper.responce;

import mate.academy.spring.dto.responce.MovieSessionResponseDto;
import mate.academy.spring.mapper.Mapper;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionResponseDtoMapper
        implements Mapper<MovieSession, MovieSessionResponseDto> {
    @Override
    public MovieSessionResponseDto map(MovieSession input) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(input.getId());
        movieSessionResponseDto.setMovieId(input.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(input.getCinemaHall().getId());
        movieSessionResponseDto.setShowTime(input.getShowTime());
        return movieSessionResponseDto;
    }
}
