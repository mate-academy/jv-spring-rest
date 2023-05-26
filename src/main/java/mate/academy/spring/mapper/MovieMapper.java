package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        return dto;
    }

    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        CinemaHall cinemaHall = new CinemaHall();
        return movie;
    }
}
