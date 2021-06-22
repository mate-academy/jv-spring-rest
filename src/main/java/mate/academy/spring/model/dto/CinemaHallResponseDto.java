package mate.academy.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
