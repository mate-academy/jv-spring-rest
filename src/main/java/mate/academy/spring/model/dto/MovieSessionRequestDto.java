package mate.academy.spring.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime showTime;
}
