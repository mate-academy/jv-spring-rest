package mate.academy.spring.dto;

public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private String date;

    public MovieSessionRequestDto(Long movieId, Long cinemaHallId, String date) {
        this.movieId = movieId;
        this.cinemaHallId = cinemaHallId;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
