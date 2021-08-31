package mate.academy.spring.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;


@Data
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    @JsonFormat(pattern = "dd.MM.yyyy - HH:mm")
    private LocalDateTime showTime;
}
