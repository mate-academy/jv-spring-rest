package mate.academy.spring.service.mapper.impl;

import lombok.AllArgsConstructor;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieSessionDtoMapperImpl implements MovieSessionDtoMapper {
    private final MovieService movieService;
    private final CinemaHallService hallService;

    @Override
    public MovieSessionResponseDto parse(MovieSession session) {
        MovieSessionResponseDto sessionResponseDto = new MovieSessionResponseDto();
        sessionResponseDto.setId(session.getId());
        sessionResponseDto.setMovieId(session.getMovie().getId());
        sessionResponseDto.setCinemaHallId(session.getCinemaHall().getId());
        sessionResponseDto.setShowTime(session.getShowTime());
        return sessionResponseDto;
    }

    @Override
    public MovieSession toModel(MovieSessionRequestDto sessionRequestDto) {
        MovieSession session = new MovieSession();
        session.setMovie(movieService.get(sessionRequestDto.getMovieId()));
        session.setCinemaHall(hallService.get(sessionRequestDto.getCinemaHallId()));
        session.setShowTime(sessionRequestDto.getShowTime());
        return session;
    }
}
