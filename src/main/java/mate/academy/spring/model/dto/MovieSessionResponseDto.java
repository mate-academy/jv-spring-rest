package mate.academy.spring.model.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private MovieIdTitleDto movieIdTitleDto;
    private CinemaHallIdNameDto cinemaHallTitleIdDto;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieIdTitleDto getMovieIdTitleDto() {
        return movieIdTitleDto;
    }

    public void setMovieIdTitleDto(MovieIdTitleDto movieIdTitleDto) {
        this.movieIdTitleDto = movieIdTitleDto;
    }

    public CinemaHallIdNameDto getCinemaHallTitleIdDto() {
        return cinemaHallTitleIdDto;
    }

    public void setCinemaHallTitleIdDto(CinemaHallIdNameDto cinemaHallTitleIdDto) {
        this.cinemaHallTitleIdDto = cinemaHallTitleIdDto;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
