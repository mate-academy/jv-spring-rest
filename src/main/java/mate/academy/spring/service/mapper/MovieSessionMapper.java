package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.moviesession.MovieSessionRequestDto;
import mate.academy.spring.dto.moviesession.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;

public interface MovieSessionMapper {
    MovieSessionResponseDto toDto(MovieSession movieSession);

    MovieSession toModel(MovieSessionRequestDto requestDto);
}
