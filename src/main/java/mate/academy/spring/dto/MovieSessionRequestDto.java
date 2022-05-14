package mate.academy.spring.dto;

import java.time.LocalDateTime;

public class MovieSessionRequestDto {
    private Long id;
    private MovieRequestDto movie;
    private CinemaHallRequestDto cinemaHall;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieRequestDto getMovie() {
        return movie;
    }

    public void setMovie(MovieRequestDto movie) {
        this.movie = movie;
    }

    public CinemaHallRequestDto getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHallRequestDto cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
