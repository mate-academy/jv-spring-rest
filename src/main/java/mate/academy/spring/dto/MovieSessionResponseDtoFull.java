package mate.academy.spring.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDtoFull {
    private Long id;
    private Long movieId;
    private String movieTitle;
    private String movieDescription;
    private Long cinemaHallId;
    private int cinemaHallCapacity;
    private String cinemaHallDescription;
    private LocalDateTime showTime;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public int getCinemaHallCapacity() {
        return cinemaHallCapacity;
    }

    public void setCinemaHallCapacity(int cinemaHallCapacity) {
        this.cinemaHallCapacity = cinemaHallCapacity;
    }

    public String getCinemaHallDescription() {
        return cinemaHallDescription;
    }

    public void setCinemaHallDescription(String cinemaHallDescription) {
        this.cinemaHallDescription = cinemaHallDescription;
    }

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
