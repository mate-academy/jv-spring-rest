package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import org.springframework.format.annotation.DateTimeFormat;

public class MovieSessionRequestDto {
    private Movie movie;
    private CinemaHall cinemaHall;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime showTime;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
