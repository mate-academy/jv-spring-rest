package mate.academy.spring.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private Long cinemaHallId;
    private Long movieId;
    private LocalDateTime showTime;

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "MovieSessionResponseDto{"
                + "id=" + id
                + ", cinemaHallId=" + cinemaHallId
                + ", movieId=" + movieId
                + ", showTime=" + showTime
                + '}';
    }
}
