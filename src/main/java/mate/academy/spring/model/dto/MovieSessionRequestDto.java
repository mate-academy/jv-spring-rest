package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MovieSessionRequestDto {
    private Long cinemaHallId;
    private Long movieId;
    private LocalDateTime showTime;
}
