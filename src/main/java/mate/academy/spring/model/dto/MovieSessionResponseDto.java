package mate.academy.spring.model.dto;

import java.time.LocalDate;

public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHall;
    private LocalDate showTime;

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

    public Long getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(Long cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public LocalDate getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDate showTime) {
        this.showTime = showTime;
    }
}
