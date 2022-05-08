package mate.academy.spring.dto;

import java.time.LocalDateTime;

public class MovieSessionDto {
    private Long id;
    private MovieDto movie;
    private CinemaHallDto cinemaHall;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieDto getMovie() {
        return movie;
    }

    public void setMovie(MovieDto movie) {
        this.movie = movie;
    }

    public CinemaHallDto getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHallDto cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
