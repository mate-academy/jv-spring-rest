package mate.academy.spring.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record MovieSessionRequestDto(Long movieId,
                                     Long cinemaHallId,
                                     @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
                                     LocalDateTime showTime) {
}
