package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionMapper {
    private MovieMapper movieMapper;
    private MovieService movieService;
    private CinemaHallService cinemaHallService;
    private CinemaHallMapper cinemaHallMapper;

    public MovieSession convert(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getId()));
        movieSession.setCinemaHall(
                cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }

    public MovieSessionResponseDto parse(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieDto(
                movieMapper.parse(movieSession.getMovie()));
        movieSessionResponseDto.setCinemaHallDto(
                cinemaHallMapper.parse(movieSession.getCinemaHall()));
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }
}
