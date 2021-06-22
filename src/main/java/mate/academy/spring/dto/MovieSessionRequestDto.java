package mate.academy.spring.dto;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;

public class MovieSessionRequestDto {
    private Movie movie;
    private CinemaHall cinemaHall;
    private String showTime;

    public Movie getMovie() {
        return movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public String getShowTime() {
        return showTime;
    }
}
