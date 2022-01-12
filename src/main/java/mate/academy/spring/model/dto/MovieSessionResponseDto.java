package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;
}
