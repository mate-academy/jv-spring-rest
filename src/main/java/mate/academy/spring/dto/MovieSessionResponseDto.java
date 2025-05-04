package mate.academy.spring.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private MovieResponseDto movieResponseDto;
    private CinemaHallResponseDto cinemaHallResponseDto;
    private LocalDateTime localDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieResponseDto getMovieResponseDto() {
        return movieResponseDto;
    }

    public void setMovieResponseDto(MovieResponseDto movieResponseDto) {
        this.movieResponseDto = movieResponseDto;
    }

    public CinemaHallResponseDto getCinemaHallResponseDto() {
        return cinemaHallResponseDto;
    }

    public void setCinemaHallResponseDto(CinemaHallResponseDto cinemaHallResponseDto) {
        this.cinemaHallResponseDto = cinemaHallResponseDto;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
