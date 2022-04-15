package mate.academy.spring.model.dto.response;

public class MovieSessionResponseDto {
    private long id;
    private long movie;
    private long cinemaHallId;
    private String showTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
