package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.request.MovieRequestDto;
import mate.academy.spring.dto.response.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper implements GenericDtoMapper<MovieRequestDto, MovieResponseDto, Movie> {

    @Override
    public MovieResponseDto toDto(Movie movie) {
        return new MovieResponseDto()
                .setId(movie.getId())
                .setTitle(movie.getTitle())
                .setDescription(movie.getDescription());
    }

    @Override
    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
