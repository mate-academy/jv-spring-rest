package mate.academy.spring.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CinemaHallRequestDto {
    private int capacity;
    private String description;
}
