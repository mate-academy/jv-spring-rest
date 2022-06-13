package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {

        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movieSession.getMovie().getId());
        movieResponseDto.setTitle(movieSession.getMovie().getTitle());
        movieResponseDto.setDescription(movieSession.getMovie().getDescription());
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(movieSession.getCinemaHall().getId());
        cinemaHallResponseDto.setCapacity(movieSession.getCinemaHall().getCapacity());
        cinemaHallResponseDto.setDescription(movieSession.getCinemaHall().getDescription());
        MovieSessionResponseDto movieSessionResponseDto
                = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovie(movieResponseDto);
        movieSessionResponseDto.setCinemaHall(cinemaHallResponseDto);
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
