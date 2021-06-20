package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MovieSessionResponceDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;
}
