package mate.academy.spring.dto;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class MovieSessionRequestDto {
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime showTime;
    private Long movieId;
    private Long cinemaHallId;

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

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
