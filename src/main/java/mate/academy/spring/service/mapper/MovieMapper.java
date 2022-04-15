package mate.academy.spring.service.mapper;

import java.util.List;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "id", source = "movie.id")
    @Mapping(target = "title", source = "movie.title")
    @Mapping(target = "description", source = "movie.description")
    MovieResponseDto movieToMovieResponseDto(Movie movie);

    @Mapping(target = "title", source = "dto.title")
    @Mapping(target = "description", source = "dto.description")
    Movie movieRequestDtoToMovie(MovieRequestDto dto);

    List<MovieResponseDto> movieListToResponseDtoList(List<Movie> list);
}
