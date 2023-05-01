package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper {
    MovieSessionResponseDto parseToDto(MovieSession movieSession);

    MovieSession parseToModel(MovieSessionRequestDto movieSessionRequestDto);
}
