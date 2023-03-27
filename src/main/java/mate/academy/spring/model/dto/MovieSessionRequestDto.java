package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class MovieSessionRequestDto {
    private Long cinemaHallId;
    private Long movieId;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime showTime;

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
