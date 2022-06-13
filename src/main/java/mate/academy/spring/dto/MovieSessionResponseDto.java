package mate.academy.spring.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private MovieResponseDto movie;
    private CinemaHallResponseDto cinemaHall;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieResponseDto getMovie() {
        return movie;
    }

    public void setMovie(MovieResponseDto movie) {
        this.movie = movie;
    }

    public CinemaHallResponseDto getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHallResponseDto cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
