package mate.academy.spring.model.dto;

import java.time.LocalDateTime;

public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;

    public Long getMovieId() {
        return movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }
}
