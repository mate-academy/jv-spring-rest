package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;

@Data
@AllArgsConstructor
public class MovieSessionResponseDto {
    private Long id;
    private Movie movie;
    private CinemaHall cinemaHall;
    private LocalDateTime localDateTime;

    public Long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
