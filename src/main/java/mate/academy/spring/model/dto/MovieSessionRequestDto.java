package mate.academy.spring.model.dto;

import java.time.LocalDateTime;

public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;

    public Long getMovie() {
        return movieId;
    }

    public void setMovie(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHall() {
        return cinemaHallId;
    }

    public void setCinemaHall(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
