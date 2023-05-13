package mate.academy.spring.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private String showTime;
}
