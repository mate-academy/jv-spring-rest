package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;

public interface MovieSessionMapper extends
        Mapper<MovieSessionRequestDto, MovieSessionResponseDto, MovieSession> {
}
