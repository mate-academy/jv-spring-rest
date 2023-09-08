package mate.academy.spring.mapper.responce;

import mate.academy.spring.dto.responce.MovieResponseDto;
import mate.academy.spring.mapper.Mapper;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieResponseDtoMapper implements Mapper<Movie, MovieResponseDto> {
    @Override
    public MovieResponseDto map(Movie input) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(input.getId());
        movieResponseDto.setTitle(input.getTitle());
        movieResponseDto.setDescription(input.getDescription());
        return movieResponseDto;
    }
}
