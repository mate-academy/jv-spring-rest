package mate.academy.spring.model.dto;

import lombok.Setter;

@Setter
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private String showTime;
}
