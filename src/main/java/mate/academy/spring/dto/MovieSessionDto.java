package mate.academy.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieSessionDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime showTime;
}
