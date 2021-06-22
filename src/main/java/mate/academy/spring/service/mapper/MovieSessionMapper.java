package mate.academy.spring.service.mapper;

import java.time.LocalDateTime;
import mate.academy.spring.dao.CinemaHallService;
import mate.academy.spring.dao.MovieServise;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private MovieServise movieDao;
    private CinemaHallService cinemaHallDao;

    public MovieSessionMapper(MovieServise movieDao, CinemaHallService cinemaHallDao) {
        this.movieDao = movieDao;
        this.cinemaHallDao = cinemaHallDao;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieId(movieSession.getMovie().getId());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime().toString());
        return movieSessionResponseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieDao.get(
                movieSessionRequestDto.getMovieId()).get());
        movieSession.setCinemaHall(cinemaHallDao.get(
                movieSessionRequestDto.getCinemaHallId()).get());
        movieSession.setShowTime(LocalDateTime.parse(movieSessionRequestDto.getShowTime()));
        return movieSession;
    }
}
