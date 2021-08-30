package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;

public interface MovieSessionDtoMapper extends GenericDtoMapper<MovieSession,
        MovieSessionResponseDto, MovieSessionRequestDto> {
}
