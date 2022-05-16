package mate.academy.spring.dto;

import java.time.LocalDateTime;

public class MovieSessionRequestDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private MovieRequestDto movieDto;
    private CinemaHallRequestDto cinemaHallDto;
    private LocalDateTime showTime;

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

    public MovieRequestDto getMovieDto() {
        return movieDto;
    }

    public void setMovieDto(MovieRequestDto movieDto) {
        this.movieDto = movieDto;
    }

    public CinemaHallRequestDto getCinemaHallDto() {
        return cinemaHallDto;
    }

    public void setCinemaHallDto(CinemaHallRequestDto cinemaHallDto) {
        this.cinemaHallDto = cinemaHallDto;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
