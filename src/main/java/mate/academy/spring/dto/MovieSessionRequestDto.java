package mate.academy.spring.dto;

import java.time.LocalDateTime;

public class MovieSessionRequestDto {
    private LocalDateTime showTime;
    private Long movieId;
    private long cinemaHallId;

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(long cinemaHallIs) {
        this.cinemaHallId = cinemaHallIs;
    }
}
