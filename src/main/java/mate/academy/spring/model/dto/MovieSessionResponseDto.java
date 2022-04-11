package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private Long cinemaHallId;
    private LocalDateTime showTime;
}
