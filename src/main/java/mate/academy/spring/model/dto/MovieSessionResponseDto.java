package mate.academy.spring.model.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private LocalDateTime showTime;
    private Long movieId;
    private Long cinemaHallId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "MovieSessionResponseDto{"
                + "id=" + id
                + ", showTime=" + showTime
                + ", movieId=" + movieId
                + ", cinemaHallId=" + cinemaHallId
                + '}';
    }
}
