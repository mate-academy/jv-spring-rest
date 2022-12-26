package mate.academy.spring.dto.response;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Accessors(chain = true)
@Setter
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime showTime;
}
