package mate.academy.spring.service;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;

public interface MovieSessionMapper {
    MovieSessionResponseDto toDto(MovieSession movieSession);

    MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto);
}
