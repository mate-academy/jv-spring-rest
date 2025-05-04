package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private Long cinemaHallId;
    private LocalDateTime showTime;

    public MovieSessionResponseDto() {
    }

    public MovieSessionResponseDto(Long id,
                                   String movieTitle,
                                   Long cinemaHallId,
                                   LocalDateTime showTime) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.cinemaHallId = cinemaHallId;
        this.showTime = showTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
