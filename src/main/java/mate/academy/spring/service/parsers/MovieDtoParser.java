package mate.academy.spring.service.parsers;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.request.MovieRequestDto;
import mate.academy.spring.model.dto.response.MovieResponseDto;
import org.springframework.stereotype.Service;

@Service
public class MovieDtoParser {

    public Movie parseRequestToEntity(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setTitle(requestDto.getTitle());
        movie.setDescription(requestDto.getDescription());
        return movie;
    }

    public MovieResponseDto parseEntityToResponse(Movie entity) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(entity.getId());
        movieResponseDto.setTitle(entity.getTitle());
        movieResponseDto.setDescription(entity.getDescription());
        return movieResponseDto;
    }
}
