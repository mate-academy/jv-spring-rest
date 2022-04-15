package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;

public class MovieSessionRequestDto {
    private long movie;
    private long cinemaHallId;
    private LocalDateTime showTime;

    public long getMovie() {
        return movie;
    }

    public void setMovie(long movie) {
        this.movie = movie;
    }

    public long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
