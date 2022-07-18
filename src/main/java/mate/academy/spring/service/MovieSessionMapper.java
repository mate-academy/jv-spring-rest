package mate.academy.spring.service;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper {
    MovieSessionResponseDto toDto(MovieSession movieSession);

    MovieSession toModel(MovieSessionRequestDto dto);
}
