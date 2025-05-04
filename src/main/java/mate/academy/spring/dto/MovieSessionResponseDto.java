package mate.academy.spring.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }
}
