package mate.academy.spring.dto.request;

import java.time.LocalDateTime;

public class MovieSessionRequestDto {

    private Long movieId;
    private Long cinemaHallID;
    private LocalDateTime showTime;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallID() {
        return cinemaHallID;
    }

    public void setCinemaHallID(Long cinemaHallID) {
        this.cinemaHallID = cinemaHallID;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
