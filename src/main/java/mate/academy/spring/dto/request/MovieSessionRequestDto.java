package mate.academy.spring.dto.request;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;
}
