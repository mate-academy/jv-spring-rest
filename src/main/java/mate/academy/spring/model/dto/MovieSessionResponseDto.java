package mate.academy.spring.model.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private String movieTitle;
    private Long cinemaHallId;
    private String cinemaHallTitle;
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

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getCinemaHallTitle() {
        return cinemaHallTitle;
    }

    public void setCinemaHallTitle(String cinemaHallTitle) {
        this.cinemaHallTitle = cinemaHallTitle;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
