package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto mrd = new MovieResponseDto();
        mrd.setId(movie.getId());
        mrd.setDescription(movie.getDescription());
        mrd.setTitle(movie.getTitle());
        return mrd;
    }

    public Movie toModel(MovieRequestDto mrd) {
        Movie movie = new Movie();
        movie.setDescription(mrd.getDescription());
        movie.setTitle(mrd.getTitle());
        return movie;
    }
}
