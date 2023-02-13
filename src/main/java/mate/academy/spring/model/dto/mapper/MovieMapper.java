package mate.academy.spring.model.dto.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieResponseDto toDto(Movie movie) {
        Long id = movie.getId();
        String title = movie.getTitle();
        String description = movie.getDescription();
        return new MovieResponseDto(id, title, description);
    }

    public Movie toModel(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setTitle(requestDto.title());
        movie.setDescription(requestDto.description());
        return movie;
    }
}
