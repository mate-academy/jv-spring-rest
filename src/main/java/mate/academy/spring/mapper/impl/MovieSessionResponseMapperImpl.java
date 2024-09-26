package mate.academy.spring.mapper.impl;

import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.mapper.MovieSessionResponseMapper;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionResponseMapperImpl implements MovieSessionResponseMapper {
    @Override
    public MovieSessionResponseDto toDto(MovieSession model) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(model.getId());
        movieSessionResponseDto.setMovieId(model.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(model.getCinemaHall().getId());
        movieSessionResponseDto.setShowTime(model.getShowTime());
        return movieSessionResponseDto;
    }
}
