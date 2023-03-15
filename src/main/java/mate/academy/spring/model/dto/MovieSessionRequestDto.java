package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class MovieSessionRequestDto {
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private int movieId;
    private int cinemaHallId;
    private LocalDateTime showTime;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(int cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
