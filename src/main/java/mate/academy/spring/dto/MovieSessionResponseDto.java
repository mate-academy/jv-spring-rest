package mate.academy.spring.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long CinemaHallId;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallId() {
        return CinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        CinemaHallId = cinemaHallId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
