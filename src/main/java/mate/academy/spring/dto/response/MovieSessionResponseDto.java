package mate.academy.spring.dto.response;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
//    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime showTime;
}
