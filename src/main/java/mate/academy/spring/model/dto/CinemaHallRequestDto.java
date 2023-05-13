package mate.academy.spring.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CinemaHallRequestDto {
    private int capacity;
    private String description;
}
