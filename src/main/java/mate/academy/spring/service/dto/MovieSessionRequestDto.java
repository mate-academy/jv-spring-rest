package mate.academy.spring.service.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;

@Getter
@Setter
public class MovieSessionRequestDto {
    private Movie movie;
    private CinemaHall cinemaHall;
    private LocalDateTime showTime;
}
