package mate.academy.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
