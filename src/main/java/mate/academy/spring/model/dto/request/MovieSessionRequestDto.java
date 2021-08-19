package mate.academy.spring.model.dto.request;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;

public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;

    public Long getMovieId() {
        return movieId;
    }

    public MovieSessionRequestDto setMovieId(Long movieId) {
        this.movieId = movieId;
        return this;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public MovieSessionRequestDto setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
        return this;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public MovieSessionRequestDto setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
        return this;
    }
}
