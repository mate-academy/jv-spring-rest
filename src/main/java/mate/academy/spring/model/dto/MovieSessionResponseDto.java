package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;
}
