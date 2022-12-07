package mate.academy.spring.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
