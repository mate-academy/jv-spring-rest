package mate.academy.spring.dto.response;

import java.time.LocalDateTime;
import lombok.Data;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;

@Data
public class MovieSessionResponseDto {
    private Long id;
    private Movie movie;
    private CinemaHall cinemaHall;
    private LocalDateTime showTime;
}
