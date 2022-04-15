package mate.academy.spring.model.dto;

import lombok.Getter;

@Getter
public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private String showTime;
}
