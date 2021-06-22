package mate.academy.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
