package mate.academy.spring.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CinemaHallRequestDto {
    private int capacity;
    private String description;
}
