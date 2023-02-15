package mate.academy.spring.service;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper {
    public MovieSessionResponseDto toDto(MovieSession movieSession);

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto);
}
