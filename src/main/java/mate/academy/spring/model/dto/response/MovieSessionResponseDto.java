package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public MovieSessionResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getMovieId() {
        return movieId;
    }

    public MovieSessionResponseDto setMovieId(Long movieId) {
        this.movieId = movieId;
        return this;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public MovieSessionResponseDto setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
        return this;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public MovieSessionResponseDto setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
        return this;
    }
}
