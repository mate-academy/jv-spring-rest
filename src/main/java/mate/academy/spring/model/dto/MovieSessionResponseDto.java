package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;

    public MovieSessionResponseDto(Long id, Long movieId, Long cinemaHallId,
            LocalDateTime showTime) {
        this.id = id;
        this.movieId = movieId;
        this.cinemaHallId = cinemaHallId;
        this.showTime = showTime;
    }
}
