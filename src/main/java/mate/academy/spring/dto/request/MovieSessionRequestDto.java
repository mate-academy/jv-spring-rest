package mate.academy.spring.dto.request;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime showTime;
}
