package mate.academy.spring.dao.dto;

import java.time.LocalDateTime;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;

public class MovieSessionRequestDto {
    private Movie movie;
    private CinemaHall cinemaHall;
    private LocalDateTime showTime;
}
