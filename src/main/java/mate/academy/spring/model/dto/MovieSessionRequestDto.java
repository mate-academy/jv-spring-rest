package mate.academy.spring.model.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;
}
