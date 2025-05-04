package mate.academy.spring.dto.moviesession;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime showTime;

    public MovieSessionRequestDto() {
    }

    public MovieSessionRequestDto(Long movieId, Long cinemaHallId, LocalDateTime showTime) {
        this.movieId = movieId;
        this.cinemaHallId = cinemaHallId;
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

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
